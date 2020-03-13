package com.telda.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReadMainController {

    @RequestMapping("/read_directory")
    public String index(){
        return "view_read_main";
    }
}
