package com.telda.springweb.controllers;

import com.telda.springweb.entity.Region;
import com.telda.springweb.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChangeCorrectionController {
    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    public ChangeCorrectionController(RegionRepository regionRepository) {
       this.regionRepository = regionRepository;
    }

    @RequestMapping(value = "/change_directory_correction", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("region", new Region());
        return "view_change_directory_correction";
    }

    @RequestMapping(value = "/change_directory_correction", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Region region){
        regionRepository.save(region);
       return "view_change_directory_correction";

    }

}
