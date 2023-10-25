package com.fa.training;


import com.fa.training.entity.Member;
import com.fa.training.entity.Role;
import com.fa.training.entity.enums.ERole;
import com.fa.training.repository.IMemberRepository;
import com.fa.training.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class SpringBootJpaSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaSecurityApplication.class, args);
	}

//	@Autowired
//	private IRoleRepository roleRepository ;
//
//	@Autowired
//	private IMemberRepository memberRepository;
//
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public void run(String... args) throws Exception {
//		Role roleUser = new Role(ERole.USER);
//		Role roleAdmin = new Role(ERole.ADMIN);
//		roleRepository.save(roleUser);
//		roleRepository.save(roleAdmin);
//		        Member user = new Member("huynguyen", bCryptPasswordEncoder.encode("huynguyen"));
//        user.setRoles(new HashSet<>(roleRepository.findByName(ERole.ADMIN)));
//        memberRepository.save(user);
	}
}


