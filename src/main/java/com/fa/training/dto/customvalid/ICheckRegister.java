package com.fa.training.dto.customvalid;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckRegisterValidator.class)
@Documented
public @interface ICheckRegister {

    String message() default "no";
    String  messageUsername() default "not";
    String messageEmail() default "not";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


    String username();
    String email();

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List
    {
        ICheckRegister[] value();
    }
}
