package assignment11.laptop.Service;

import assignment11.laptop.Exceptions.LaptopAlreadyExistsException;
import assignment11.laptop.Exceptions.LaptopNotFoundException;
import assignment11.laptop.Exceptions.TypeNotAllowedException;
import assignment11.laptop.Model.Laptop;
import assignment11.laptop.Repository.*;
import assignment11.laptop.Validators.TypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaptopServiceImp implements LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;
    @Autowired
    private SpecificationRepository specificationRepository;
    @Autowired
    private TypeValidator validate;

    @Override
    public Laptop add(Laptop laptop) {
        try {
            if (laptopRepository.existsById(laptop.getId()))
                throw new LaptopAlreadyExistsException("Duplicate Laptop Id: " + laptop.getId());
            else if (!(validate.findType(laptop.getType())))
                throw new TypeNotAllowedException("Only LG,Sony,HP and Dell Laptops are allowed.");
//            else if(!(specificationRepository.existsById(laptop.getSpecsId())))
//                throw new ModelNotFoundException("Model Id either not present or not entered correctly....");
            else {
                laptopRepository.save(laptop);
                System.out.println("Data Inserted Successfully......");
            }
        } catch (LaptopAlreadyExistsException le) {
            System.out.println(le.getMessage());
        } catch (TypeNotAllowedException te) {
            System.out.println(te.getMessage());
        }
//        catch (ModelNotFoundException me){
//            System.out.println(me.getMessage());
//        }
        return laptop;
    }

    @Override
    public void update(long id, Laptop laptop) {
        try {
            if (!(laptopRepository.existsById(id)))
                throw new LaptopNotFoundException("Laptop with Id: " + id + " not found.");
            else {
                laptopRepository.save(laptop);
                System.out.println("Records Updated Successfully....");
            }
        }catch (LaptopNotFoundException le){
            System.out.println(le.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        try {
            if (!(laptopRepository.existsById(id)))
                throw new LaptopNotFoundException("Laptop Does not Exist with Id:" + id);
            else{
                laptopRepository.deleteById(id);
                System.out.println("Records deleted successfully....");
            }
        }catch (LaptopNotFoundException lf){
            System.out.println(lf.getMessage());
        }
    }

    @Override
    public Laptop show(long id) {
        Laptop l = new Laptop();
        try {
            if (!(laptopRepository.existsById(id)))
                throw new LaptopNotFoundException("Laptop Does not Exist with Id:" + id);
            else
                return laptopRepository.findById(id).get();
        }catch (LaptopNotFoundException lf){
            System.out.println(lf.getMessage());
        }
        return l;
    }
    @Override
    public List<Laptop> getAll(){
        System.out.println("The Entire Record of Laptop Table !!!!");
        return laptopRepository.findAll();
    }

    // Query methods

    @Override
    public List<Laptop> getLaptopsByTypes(String typename) {
        return laptopRepository.getLaptopsByTypes(typename);
    }

    @Override
    public int updatelaptopsById(String type, Long id) {
        return laptopRepository.updateLaptopsById(type, id);
    }


}

