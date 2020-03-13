package com.telda.springweb.controllers;

import com.telda.springweb.entity.Region;
import com.telda.springweb.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ChangeAddController {
    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    public ChangeAddController(RegionRepository regionRepository) {
       this.regionRepository = regionRepository;
    }

    @RequestMapping(value = "/change_directory_add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("region", new Region());
        return "view_change_directory_add";
    }

    @RequestMapping(value = "/change_directory_add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Region region){
        regionRepository.save(region);
       return "view_change_directory_add";
    }

}
