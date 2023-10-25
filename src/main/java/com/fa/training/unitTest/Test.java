package com.fa.training.unitTest;

import com.fa.training.entity.Role;
import com.fa.training.entity.enums.ERole;
import com.fa.training.repository.IMemberRepository;
import com.fa.training.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Service
public class Test {



    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm", Locale.ENGLISH);
        System.out.println(LocalDateTime.now().format(formatter));
    }




}
