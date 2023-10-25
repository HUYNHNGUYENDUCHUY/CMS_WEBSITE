package com.fa.training.dto.forlogin;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LMember {
    private Long id;

    @NotBlank(message = "you must insert username")
    @Size(min = 6, max = 20, message = "Length of lastname should be from 6 to 20")
    private String username;

    @NotBlank(message = "you must insert password")
    @Size(min = 6, max = 20, message = "Length of lastname should be from 6 to 20")
    private String password;
}
