package assignment11.laptop.Service;

import assignment11.laptop.Exceptions.DuplicateDataException;
import assignment11.laptop.Exceptions.LaptopNotFoundException;
import assignment11.laptop.Model.Specification;
import assignment11.laptop.Repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpecificationServiceImp implements SpecificationService{
    @Autowired
    private SpecificationRepository specificationRepository;

    @Override
    public Specification add(Specification specification) {
        try {
            if (specificationRepository.existsById(specification.getSpecsId()))
                throw new DuplicateDataException("Duplicate Laptop, Id: " + specification.getSpecsId());
            else {
                specificationRepository.save(specification);
                System.out.println("Data Entered Successfully...");
            }
        }catch (DuplicateDataException de){
            System.out.println(de.getMessage());
        }
        return specification;
    }

    @Override
    public void update(long specsId, Specification specification) {
        try {
            if (!(specificationRepository.existsById(specsId)))
                throw new LaptopNotFoundException("Laptop with Specification Id: " + specsId + " not found.");
            else {
                specificationRepository.save(specification);
                System.out.println("Records Updated Successfully....");
            }
        }catch (LaptopNotFoundException le){
            System.out.println(le.getMessage());
        }

    }

    @Override
    public void delete(long id) {
        try {
            if (!(specificationRepository.existsById(id)))
                throw new LaptopNotFoundException("Laptop Does not Exist with Id:" + id);
            else{
                specificationRepository.deleteById(id);
                System.out.println("Records deleted successfully....");
            }
        }catch (LaptopNotFoundException lf){
            System.out.println(lf.getMessage());
        }
    }

    @Override
    public Specification show(long specsId) {
        Specification s = new Specification();
        try {
            if (!(specificationRepository.existsById(specsId)))
                throw new LaptopNotFoundException("Laptop with the specification does not exist with Id:" + specsId);
            else
                return specificationRepository.findById(specsId).get();
        }catch (LaptopNotFoundException lf){
            System.out.println(lf.getMessage());
        }
        return s;
    }

    @Override
    public List<Specification> getAll(){
        System.out.println("The Entire Record of Specification Table !!!!");
        return specificationRepository.findAll();
    }
}
