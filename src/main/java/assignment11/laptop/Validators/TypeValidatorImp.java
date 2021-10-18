package assignment11.laptop.Validators;

import org.springframework.stereotype.Component;

@Component
public class TypeValidatorImp implements TypeValidator{

    @Override
    public boolean findType(String type) {
        if(type.equals("Dell"))
            return true;
        else if(type.equals("HP"))
            return true;
        else if(type.equals("Sony"))
            return true;
        else if(type.equals("LG"))
            return true;
        else
            return false;
    }

}
