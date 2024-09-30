package com.wo.gmnt.web.controller;

import com.wo.gmnt.model.GmsArea;
import com.wo.gmnt.model.GmsEquip;
import com.wo.gmnt.model.GmsProp;
import com.wo.gmnt.service.GmsAreaService;
import com.wo.gmnt.service.GmsEquipService;
import com.wo.gmnt.service.GmsPropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/medical-equipment")
@RequiredArgsConstructor
public class MedicalEquipmentController {
    private final GmsEquipService equipService;
    private final GmsAreaService areaService;
    private final GmsPropService propService;

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
    public String saveMedicalEquipment(GmsEquip equip, @RequestParam("idArea") String idArea, @RequestParam("idPro") String idPro) {
        GmsProp prop = propService.findById(idPro).orElse(null);
        GmsArea area = areaService.findById(idArea).orElse(null);
        equip.setGmsProp(prop);
        equip.setGmsArea(area);
        equipService.save(equip);
        return "redirect:/";
    }

}
