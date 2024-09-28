package com.wo.gmnt.web.controller;

import com.wo.gmnt.model.GmsEquip;
import com.wo.gmnt.service.GmsEquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/medical-equipment")
@RequiredArgsConstructor
public class MedicalEquipmentController {
    private final GmsEquipService equipService;

    @RequestMapping("new")
    public String medicalEquipment(Model model) {
        GmsEquip equip = new GmsEquip();
        model.addAttribute("equip", equip);

        return "medical-equipment";
    }

    @GetMapping("/all")
    public String allMedicalEquipment(Model model) {
        model.addAttribute("equips", equipService.findAll());
        return "home";
    }

    @PostMapping("/save")
    public String saveMedicalEquipment(GmsEquip equip) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.format(new Date());

        //equip.setFchieq(equip.getFchieq() + timeFormat);
        equipService.save(equip);
        return "redirect:/";
    }

}
