package assignment11.laptop.Validators;

import org.springframework.stereotype.Component;

@Component
public interface TypeValidator {
    public boolean findType(String type);
}
