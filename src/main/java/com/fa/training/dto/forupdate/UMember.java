package com.fa.training.dto.forupdate;


import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UMember {
    private Long id;
    private String password;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String description;
}
