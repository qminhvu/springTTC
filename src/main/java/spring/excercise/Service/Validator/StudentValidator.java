package spring.excercise.Service.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import spring.excercise.Model.Entities.Student;

@Component
public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(e, "id", "id.empty");
        ValidationUtils.rejectIfEmpty(e, "birthday", "birthday.empty");
        ValidationUtils.rejectIfEmpty(e, "address", "address.empty");
        ValidationUtils.rejectIfEmpty(e, "phoneNumber", "phoneNumber.empty");
        ValidationUtils.rejectIfEmpty(e, "aClass", "aClass.empty");
    }
}
