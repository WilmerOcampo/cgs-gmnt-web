package com.wo.gmnt.web.controller;

import com.wo.gmnt.service.GmsEquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medical-equipment")
@RequiredArgsConstructor
public class MedicalEquipmentController {
    private final GmsEquipService equipService;

    @RequestMapping("new")
    public String medicalEquipment() {
        return "medical-equipment";
    }

    @GetMapping("/all")
    public String allMedicalEquipment(Model model) {
        model.addAttribute("equips", equipService.findAll());
        return "home";
    }

}
