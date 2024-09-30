package com.wo.gmnt.web.controller;

import com.wo.gmnt.service.GmsEquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {
    private final GmsEquipService equipService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("equips", equipService.findAll());
        return "home";
    }

    @GetMapping("/modals")
    public String modals() {
        return "modals";
    }

}
