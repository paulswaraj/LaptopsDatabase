package assignment11.laptop.Model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Specifications")
public class Specification {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long specsId;

    @Length(max = 20)
    @NotNull(message = "Cannot be Null")
    private String operatingSys;

    @Length(max = 50)
    @NotNull(message = "Cannot be Null")
    private String processor;

    @Length(max = 10)
    @NotNull(message = "Cannot be Null")
    private long hardDisk;

    @Length(max = 10)
    @NotNull(message = "Cannot be Null")
    private long ram;

//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
//    private List<Laptop> laptop;

//    @OneToOne(targetEntity = Laptop.class)
//    private List<Laptop> laptop;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "specifications_id", referencedColumnName = "specsId")
    private List<Laptop> laptop;

}
