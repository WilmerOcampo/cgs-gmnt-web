package com.wo.gmnt.web.controller;

import com.wo.gmnt.model.GmsProp;
import com.wo.gmnt.service.GmsPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/propietarios")
public class PropController {

    @Autowired
    private GmsPropService propService;

    @GetMapping
    public String listarPropietarios(Model model) {
        model.addAttribute("propietarios", propService.findAll());
        model.addAttribute("nuevoPropietario", new GmsProp());
        return "ListProp";
    }

    @PostMapping("/save")
    public String guardarPropietario(@ModelAttribute GmsProp propietario, Model model) {
        try {
            // Verifica si es una actualización o un nuevo registro
            boolean isUpdate = propietario.getIdPro() != null && !propietario.getIdPro().isEmpty();

            if (!isUpdate) {
                // Es un nuevo registro, genera un nuevo ID
                propietario.setIdPro(UUID.randomUUID().toString());
                // Establece fecha y hora de creación
                propietario.setFchcre(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                propietario.setHracre(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }

            // Lógica para determinar el tipo de persona
            String tipoDocumento = propietario.getTdipro();
            if (tipoDocumento != null) {
                if (tipoDocumento.equalsIgnoreCase("DNI") ||
                        tipoDocumento.equalsIgnoreCase("Carnet de extranjería")) {
                    propietario.setTpepro("N");
                } else if (tipoDocumento.equalsIgnoreCase("RUC")) {
                    propietario.setTpepro("J");
                }
            }

            // Guardar o actualizar el propietario
            propService.save(propietario);

            return "redirect:/propietarios";
        } catch (Exception e) {
            model.addAttribute("error", "Error al procesar el propietario: " + e.getMessage());
            return "ListProp";
        }
    }
    @GetMapping("/editar/{id}")
    public String editarPropietario(@PathVariable String id, Model model) {
        GmsProp propietario = propService.findById(id);
        model.addAttribute("nuevoPropietario", propietario);
        return "ListProp";  // Devuelve a la vista de la lista, pero con el propietario a editar
    }

    @PostMapping("/actualizar")
    public String actualizarPropietario(@ModelAttribute GmsProp propietario, Model model) {
        try {
            // Actualizar el propietario
            propService.save(propietario);
            return "redirect:/propietarios";  // Redirigir a la lista de propietarios
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el propietario: " + e.getMessage());
            return "ListProp";  // En caso de error, volver a la lista con el mensaje
        }
    }




    @PostMapping("/delete/{id}")
    public String eliminarPropietario(@PathVariable String id) {
        propService.delete(id);
        return "redirect:/propietarios";
    }





}
