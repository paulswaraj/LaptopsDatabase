package assignment11.laptop.Service;

import assignment11.laptop.Model.Laptop;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface LaptopService {
    Laptop add(Laptop laptop);
    void update(long id, Laptop laptop);
    void delete(long id);
    Laptop show(long id);
    List<Laptop> getAll();

    //Query methods
    List<Laptop> getLaptopsByTypes(String typename);
    int updatelaptopsById(String type, Long id);
}
