package assignment11.laptop.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Laptop")
public class Laptop {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Length(message = "Length Out of Bounds", min = 2, max = 4)
    @NotNull(message = "Cannot be Null")
    private String type;

//    @OneToOne(targetEntity = Specification.class)
//    private long specsId;
//
//    @OneToOne(targetEntity = Specification.class)
//    private List<Specification> specifications;
//
//    @OneToMany(mappedBy = "specsId", cascade = CascadeType.ALL)
//    private List<Specification> specifications;

}

