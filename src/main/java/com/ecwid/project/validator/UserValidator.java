package com.ecwid.project.validator;

import com.ecwid.project.model.User;
import com.ecwid.project.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {
    @Autowired
    UserService userService;

    public boolean supports(Class clazz) {
        return User.class.isAssignableFrom(clazz);
    }


    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",null, "Please, input your name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",null, "Please,input your surname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber",null, "Please, input your phone");
        String phone = user.getPhoneNumber();
        if (!phone.matches("^[0-9.()-]{10,25}$")) {
            errors.rejectValue("phoneNumber",null, "Please, check your data");

        }


    }
}
