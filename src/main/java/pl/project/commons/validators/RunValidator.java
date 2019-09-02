package pl.project.commons.validators;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import pl.project.models.Run;

public class RunValidator extends Validation {
    @Override
    public boolean supports(Class clazz) {
        return Run.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "nameRun", "nameRun.empty");
        Run run = (Run) object;
        if (run.toString().length() < 2) {
            errors.rejectValue("nameRun", "too short in letters");
        }
    }
}
