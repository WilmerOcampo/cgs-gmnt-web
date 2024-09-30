package com.wo.gmnt.web.controller;

import com.wo.gmnt.model.GmsProp;
import com.wo.gmnt.service.GmsPropService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final GmsPropService propService;

    @GetMapping("/all")
    public ResponseEntity<List<GmsProp>> allOwner(Model model) {
        return new ResponseEntity<>(propService.findAll(), HttpStatus.OK);
    }

}
