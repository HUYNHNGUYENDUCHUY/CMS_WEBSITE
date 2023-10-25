package com.fa.training.controller;


import com.fa.training.dto.forcreate.CContent;
import com.fa.training.dto.forupdate.UContent;
import com.fa.training.dto.list.LiContent;
import com.fa.training.entity.Content;
import com.fa.training.entity.Member;
import com.fa.training.service.templates.IContentService;
import com.fa.training.service.templates.IMemberService;
import com.fa.training.utils.IGetData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path = "/content")
public class ContentController {
    @Autowired
    private IContentService contentService;
    @Autowired
    private IMemberService memberService;
    @Autowired
    private IGetData getData;


    @GetMapping(path = "/list")
    public String list(Model theModel, @ModelAttribute(name = "search-title")String title){
        List<LiContent> contents ;
        String  username = getData.getUsernameFromContextHolder();
        Long id = memberService.getByUsername(username).getId();
        if(!title.isEmpty()){
            contents = contentService.getAllByAuthorIdAndTitle(id,title);
        }else {
            contents = contentService.getByAuthorId(id);
        }
        theModel.addAttribute("contents",contents);
        return "view-content";
    }
    @GetMapping(path = "/create")
    public String create(Model theModel){
        Content content = new Content();
        theModel.addAttribute("contents",content);
        return "form-content";

    }
    @PostMapping(path = "/create")
    public String create(@ModelAttribute("contents") CContent contentDto){
        contentService.save(contentDto);
        return "redirect:/content/list";
    }
    @GetMapping(path = "/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id,Model theModel){
        theModel.addAttribute("contents",contentService.getById(id));
        theModel.addAttribute("check","true");
        return "form-content";
    }
    @PostMapping(path = "/edit")
    public String edit(@ModelAttribute("contents") UContent contentDto){
        contentService.updateById(contentDto,contentDto.getId());
        return "redirect:/content/list";

    }

}
