package assignment11.laptop.Repository;

import java.util.List;
import assignment11.laptop.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    //Select type name from list of type name
    @Query("select l from Laptop l where l.type=:type")
    List<Laptop> getLaptopsByTypes(@Param("type") String type);

    //Alter table Queries
    @Modifying
    @Query("update Laptop l set l.type= ?1 where l.id = ?2")
    int updateLaptopsById(String type, Long id);

}