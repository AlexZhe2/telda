package com.telda.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangeMainController {

    @RequestMapping("/change_directory")
    public String index(){
        return "view_change_main";
    }
}
