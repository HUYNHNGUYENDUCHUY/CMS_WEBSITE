package com.fa.training.service.templates;

import com.fa.training.dto.forlogin.LMember;
import com.fa.training.dto.forcreate.CMember;
import com.fa.training.dto.forupdate.UMember;
import com.fa.training.entity.Member;

import java.util.List;

public interface IMemberService {
    List<LMember> getAll();

    List<Member> getAllMember();
    void save(CMember memberDto);
    void update(UMember memberDto);
    UMember getById(Long id);
    UMember getByUsernameAndPassword(String userName , String password );
    UMember getByUsername(String username);


    Boolean existByUsername(String username);

    Boolean existByEmail(String email);
}
