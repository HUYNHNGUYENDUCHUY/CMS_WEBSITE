package com.fa.training.dto.customvalid;

import com.fa.training.entity.Member;
import com.fa.training.service.templates.IMemberService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CheckRegisterValidator implements ConstraintValidator<ICheckRegister ,Object> {
    private String usernameCheckExist;
    private String emailCheckExist;

    private String messageForUsername;
    private String messageForEmail;
    @Autowired
    private IMemberService memberService;

    @Override
    public void initialize( ICheckRegister constraintAnnotation) {
       usernameCheckExist = constraintAnnotation.username();
       emailCheckExist = constraintAnnotation.email();
       messageForUsername = constraintAnnotation.messageUsername();
       messageForEmail = constraintAnnotation.messageEmail();
    }

    @Override
    public boolean isValid( Object value ,ConstraintValidatorContext context) {
        boolean validUsername = true;
        boolean validEmail = true;
        try {
                 String  username = BeanUtils.getProperty(value, "username");
                 String  email = BeanUtils.getProperty(value, "email");
                 validUsername = !memberService.existByUsername(username) ;
                 validEmail = !memberService.existByEmail(email);



        } catch (final Exception ignore) {
            //ignore
        }
        if (!validUsername) {
            context.buildConstraintViolationWithTemplate(messageForUsername)
                    .addPropertyNode(usernameCheckExist)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        if (!validEmail) {
            context.buildConstraintViolationWithTemplate(messageForEmail)
                    .addPropertyNode(emailCheckExist)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return validEmail && validUsername;


    }
}
