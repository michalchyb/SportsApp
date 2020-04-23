package pl.project.common.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.project.model.dto.RunDTO;

public class RunValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RunDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RunDTO runDTO = (RunDTO) target;
        if (runDTO.getName() == null) {
            errors.reject("name", "name can not be null");
        } else if (runDTO.getName().length() <= 3) {
            errors.reject("name", "name can not be that short, at least 3 characters");
        }
    }
}
