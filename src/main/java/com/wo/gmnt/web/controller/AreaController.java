package com.wo.gmnt.web.controller;

import com.wo.gmnt.model.GmsArea;
import com.wo.gmnt.service.GmsAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/area")
@RequiredArgsConstructor
public class AreaController {
    private final GmsAreaService areaService;

    @GetMapping("/all")
    public ResponseEntity<List<GmsArea>> allOwner(Model model) {
        return new ResponseEntity<>(areaService.findAll(), HttpStatus.OK);
    }

}
