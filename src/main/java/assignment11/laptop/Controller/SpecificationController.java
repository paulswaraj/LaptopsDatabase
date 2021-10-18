package assignment11.laptop.Controller;

import assignment11.laptop.Model.Specification;
import assignment11.laptop.Service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("specification")
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;

    @PostMapping("/create")
    public ResponseEntity<Specification> add(@RequestBody Specification specification) {
        Specification sp = specificationService.add(specification);
        return new ResponseEntity<>(sp, HttpStatus.CREATED);
    }
    @GetMapping({"/get/{specsId}"})
    private Specification show(@PathVariable long specsId) {
        return specificationService.show(specsId);
    }
    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") int id) {
        specificationService.delete(id);
    }
    @GetMapping("/getAll")
    private List<Specification> getall(){
        return specificationService.getAll();
    }
}
