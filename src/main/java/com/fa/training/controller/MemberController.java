package com.fa.training.controller;


import com.fa.training.dto.forlogin.LMember;
import com.fa.training.dto.forcreate.CMember;
import com.fa.training.dto.forupdate.UMember;
import com.fa.training.service.templates.IContentService;
import com.fa.training.service.templates.IMemberService;
import com.fa.training.service.templates.ISecurityService;
import com.fa.training.utils.ICheck;
import com.fa.training.utils.IGetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/member")
public class MemberController {

    @Autowired
    private ICheck check;
    @Autowired
    private IMemberService memberService;
    @Autowired
    private ISecurityService securityService;
    @Autowired
    private IGetData getData;

    @GetMapping(path = "/login")
    public String login(Model theModel){
        LMember memberDto = new LMember();
        theModel.addAttribute("member",memberDto);
        return "login-page";
    }

    @PostMapping(path = "/login")
        public String login(Model theModel,@Valid @ModelAttribute("member") LMember memberDto){
        theModel.addAttribute("members", memberService.getByUsername(memberDto.getUsername()));
        return "edit-profile";
    }
    @GetMapping(path = "/register")
    public String register(Model theModel){
        CMember memberDto = new CMember();
        theModel.addAttribute("members",memberDto);
        return "register-page";
    }
    @PostMapping(path = "/register")
    public String register(@ModelAttribute("members") @Valid CMember memberDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register-page";
        }
        memberService.save(memberDto);
        securityService.autoLogin(memberDto.getUsername(),memberDto.getPassword());
        return "redirect:/member/edit";
    }

    @GetMapping(path = "/edit")
    public String edit(Model theModel){
        String username = getData.getUsernameFromContextHolder();
        theModel.addAttribute("members",memberService.getByUsername(username));
        return "edit-profile";
    }
    @PostMapping(path = "/edit")
    public String edit( @ModelAttribute("members") UMember memberDto){
        memberService.update(memberDto);
        return "redirect:/content/list";
    }





}
