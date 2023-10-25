package com.fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


    @RequestMapping(path = "/" ,method = RequestMethod.GET)
    public String home() {
        return "redirect:/member/login";
    }

}
