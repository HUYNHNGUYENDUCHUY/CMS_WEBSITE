package com.fa.training.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class GetDataImpl implements IGetData {


    @Override
    public String getUsernameFromContextHolder() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String  username = authentication.getName();
        return username;
    }
}
