package assignment11.laptop.Service;

import assignment11.laptop.Model.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecificationService {
    Specification add(Specification specification);
    void update(long specsId, Specification specification);
    void delete(long id);
    Specification show(long specsId);
    List<Specification> getAll();
}
