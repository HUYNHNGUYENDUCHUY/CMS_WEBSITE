package com.fa.training.dto.forcreate;

import com.fa.training.dto.customvalid.FieldMatch;
import com.fa.training.dto.customvalid.ICheckRegister;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@FieldMatch(first = "password", second = "rePassword", message = "The password fields must match")
@ICheckRegister(email = "email" ,username = "username",messageUsername = "user name already exist" ,messageEmail = "email already exist")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CMember {


    @NotBlank(message = "you must insert username")
    @Size(min = 6, max = 20, message = "Length of lastname should be from 6 to 20")
    private String username;
    @NotBlank(message = "you must insert password")
    @Size(min = 6, max = 20, message = "Length of lastname should be from 6 to 20")
    private String password;

    @NotBlank(message = "you must insert email")
    @Email
    private String email;

    @NotBlank(message ="you must insert rePassword" )
    @Size(min = 6, max = 20, message = "Length of password confirm should be from 6 to 20")
    private String rePassword;


    public CMember(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
