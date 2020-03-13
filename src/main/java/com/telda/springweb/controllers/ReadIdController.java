package com.telda.springweb.controllers;

import com.telda.springweb.entity.Region;
import com.telda.springweb.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReadIdController {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    public ReadIdController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @RequestMapping(value = "/read_directory_id", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("region", new Region());
        return "view_read_directory_id";
    }

    @RequestMapping(value = "/read_directory_id", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Region region) throws Exception {
        region.setNameRegion(regionRepository.findById(region.getId()).get().getNameRegion());
        region.setShortNameRegion(regionRepository.findById(region.getId()).get().getShortNameRegion());
        return "view_read_directory_id";
    }

    @ExceptionHandler(Exception.class)
    public String genericErrorPage() {
        return "view_error";
    }
}
