package com.fa.training.utils;


import com.fa.training.dto.forlogin.LMember;
import com.fa.training.service.templates.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Check implements ICheck{

    @Autowired
    private IMemberService memberService;


    @Override
    public Boolean checkLogin(String userName, String password) {
        List<LMember> memberList= memberService.getAll();
        Boolean check = null;

        for (LMember element:memberList
             ) {

            if(userName.equals(element.getUsername()) && password.equals(element.getPassword())){
                check = true;
                break;
            }else {
                check = false;
            }
        }
        return check;

    }

    @Override
    public Boolean checkRegister(String userName, String password) {
        List<LMember> memberList= memberService.getAll();
        Boolean check = null;
        for (LMember element:memberList
        ) {

            if(userName.equals(element.getUsername()) && password.equals(element.getPassword())){
                check = false;
                break;
            }else {
                check = true;
            }
        }
        return check;

    }
}
