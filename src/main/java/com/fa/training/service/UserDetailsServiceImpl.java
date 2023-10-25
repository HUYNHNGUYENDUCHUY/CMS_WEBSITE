package com.fa.training.service;

import com.fa.training.entity.Member;
import com.fa.training.entity.Role;
import com.fa.training.repository.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IMemberRepository memberRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		Member member = memberRepository.findByUsername(username);
		if (member == null){
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : member.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().toString()));
		}
		return new org.springframework.security.core.userdetails.User(member.getUsername(), member.getPassword(),
				grantedAuthorities);
	}
}