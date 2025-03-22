package com.blurdel.web.thymeleaf.controllers;

import com.blurdel.web.thymeleaf.services.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class VersionController {

    private final VersionService service;

    @GetMapping("/versions")
    public String getVersions(Model model) {
        model.addAttribute("versions", service.getVersions());
        return "versions";
    }

}
