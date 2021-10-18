package assignment11.laptop.Controller;

import assignment11.laptop.Model.Laptop;
import assignment11.laptop.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("laptop")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @PostMapping("/create")
    public ResponseEntity<Laptop> add(@RequestBody Laptop laptop) {
        Laptop lp = laptopService.add(laptop);
        return new ResponseEntity<Laptop>(lp, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    private Laptop show(@PathVariable("id") long id) {
        return laptopService.show(id);
    }
    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") int id) {
        laptopService.delete(id);
    }

    @GetMapping("/getLaptopsByType/{type}")
    private List<Laptop> getLaptopsByTypes(@PathVariable String type){
        return laptopService.getLaptopsByTypes(type);
    }

    @PutMapping("/update/{id}")
    private void update(@PathVariable long id, @RequestBody Laptop laptop){
        ResponseEntity.ok("Data Updated Successfully !!!");
    }

    @GetMapping("/getAll")
    private List<Laptop> getAll(){
        return laptopService.getAll();
    }

    @PutMapping("/update/{type}/{id}")
    private int updateDetails(@PathVariable String type, @PathVariable Long id){
        return laptopService.updatelaptopsById(type, id);
    }

}
