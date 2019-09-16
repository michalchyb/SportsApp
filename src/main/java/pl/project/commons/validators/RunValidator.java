package pl.project.commons.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.project.models.dtos.RunDTO;

public class RunValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RunDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RunDTO runDTO = (RunDTO) target;
        if (runDTO.getNameRun() == null) {
            errors.reject("name", "wartosc nie moze być pusta");
        }
    }
}
