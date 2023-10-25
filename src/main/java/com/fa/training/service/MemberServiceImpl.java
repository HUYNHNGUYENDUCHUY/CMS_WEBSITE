package com.fa.training.service;

import com.fa.training.dto.forlogin.LMember;
import com.fa.training.dto.forcreate.CMember;
import com.fa.training.dto.forupdate.UMember;
import com.fa.training.entity.Member;
import com.fa.training.entity.enums.ERole;
import com.fa.training.repository.IMemberRepository;
import com.fa.training.repository.IRoleRepository;
import com.fa.training.service.templates.IMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    @Transactional
    public List<LMember> getAll() {
        List<LMember> member = new ArrayList<>();
        for (Member element:memberRepository.findAll()
             ) {
         LMember memberForLogin =  modelMapper.map(element, LMember.class);
         member.add(memberForLogin);
        }
        return member;
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    @Transactional
    public void save(CMember memberDto) {
        Member member = modelMapper.map(memberDto,Member.class);
        member.setPassword(bCryptPasswordEncoder.encode(memberDto.getPassword()));
        member.setRoles(new HashSet<>(roleRepository.findByName(ERole.USER)));
        memberRepository.save(member);

    }

    @Override
    @Transactional
    public void update(UMember memberDto) {
        Member member = modelMapper.map(memberDto,Member.class);
        member.setRoles(new HashSet<>(roleRepository.findByName(ERole.USER)));
        memberRepository.save(member);
    }

    @Override
    public UMember getById(Long id) {
        UMember memberDto = modelMapper.map(memberRepository.findById(id), UMember.class);
        return memberDto;
    }

    @Override
    public UMember getByUsernameAndPassword(String username, String password) {
        UMember memberDto = modelMapper.map(memberRepository.findByUsernameAndPassword(username,password), UMember.class);
        return memberDto;
    }

    @Override
    public UMember getByUsername(String username) {
        UMember memberDto = modelMapper.map(memberRepository.findByUsername(username), UMember.class);
        return memberDto;
    }

    @Override
    public Boolean existByUsername(String username){
      return memberRepository.existsByUsername(username);

    }
    @Override
    public Boolean existByEmail(String email){
        return memberRepository.existsByEmail(email);

    }

}
