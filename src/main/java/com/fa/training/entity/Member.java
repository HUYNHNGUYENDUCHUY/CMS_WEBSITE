package com.fa.training.entity;

import javax.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Member")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "menber_id")
    private Long id;


    @Column(name= "first_name")
    private String firstName ;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="user_name" ,unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="description")
    private String description;

    @Column(name = "create_date")
    private LocalDateTime  createDate;

    @Column(name = "update_time")
    private LocalDateTime  updateTime;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private Set<Content> contentSet;

    @ManyToMany
    private Set<Role> roles;

    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
