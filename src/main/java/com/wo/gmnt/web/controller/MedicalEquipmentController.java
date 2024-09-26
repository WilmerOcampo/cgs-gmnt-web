package com.wo.gmnt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medical-equipment")
public class MedicalEquipmentController {

    @RequestMapping("new")
    public String medicalEquipment() {
        return "medical-equipment";
    }

}
