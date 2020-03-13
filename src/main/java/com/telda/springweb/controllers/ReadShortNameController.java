package com.telda.springweb.controllers;

import com.telda.springweb.entity.Region;
import com.telda.springweb.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;


@Controller
public class ReadShortNameController {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    public ReadShortNameController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @RequestMapping(value = "/read_directory_short_name", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("region", new Region());
        return "view_read_directory_short_name";
    }

    @RequestMapping(value = "/read_directory_short_name", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Region region) throws Exception {

        ArrayList<Region> arrayListRegion = new ArrayList<>();

        for (Region reg : regionRepository.findAll()) {
            arrayListRegion.add(reg);
        }

        region.setNameRegion("");

        if (!region.getShortNameRegion().equals("")) {

            boolean correctRequest = false;
            for (int i = 0; i < arrayListRegion.size(); i++) {
                if (region.getShortNameRegion().equals(arrayListRegion.get(i).getShortNameRegion())) {
                    region.setId(arrayListRegion.get(i).getId());
                    region.setNameRegion(arrayListRegion.get(i).getNameRegion());
                    correctRequest = true;
                }
            }
            if (correctRequest == false) {
                return "view_error";
            }

        } else {
            return "view_error";
        }

        return "view_read_directory_short_name";
    }

    @ExceptionHandler(Exception.class)
    public String genericErrorPage() {
        return "view_error";
    }
}
