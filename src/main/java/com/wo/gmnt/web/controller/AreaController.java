package com.wo.gmnt.web.controller;

import com.wo.gmnt.model.GmsArea;
import com.wo.gmnt.service.GmsAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Area;
import java.util.List;
@Controller
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    private GmsAreaService areaService;

    // Mostrar la lista de áreas

    @GetMapping
    public String getAllAreas(Model model) {
        List<GmsArea> areas = areaService.findAll();
        model.addAttribute("areas", areas);
        return "ListAreas"; // Devuelve una vista Thymeleaf llamada "list.html" dentro de "templates/areas"
    }






    // Guardar un área
    @PostMapping("/guardar")
    public String createArea(@ModelAttribute GmsArea area) {
        areaService.save(area);
        return "redirect:/areas";
    }

    // Mostrar formulario para editar un área
    @GetMapping("/editarArea/{id}")
    @ResponseBody
    public GmsArea editArea(@PathVariable String id) {
        return areaService.findById(id);
    }

    // Actualizar un área
    @PostMapping("/actualizar/{id}")
    public String updateArea(@PathVariable String id, @ModelAttribute GmsArea area) {
        area.setIdAre(id);
        areaService.save(area);
        return "redirect:/areas";
    }

    // Eliminar un área
    @GetMapping("/eliminar/{id}")
    public String deleteArea(@PathVariable String id) {
        areaService.delete(id);
        return "redirect:/areas";
    }

}
