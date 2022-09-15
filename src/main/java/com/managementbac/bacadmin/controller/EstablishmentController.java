package com.managementbac.bacadmin.controller;

import com.managementbac.bacadmin.model.Establishment;
import com.managementbac.bacadmin.service.EstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class EstablishmentController {
    public final EstablishmentService establishmentService;

    @GetMapping("/Establishments")
    public List<Establishment> allEstablishment(){
        return establishmentService.getAllEstablishment();
    }

    @PostMapping("/Establishments")
    public List<Establishment> addEstablishment(@RequestBody List<Establishment> establishments){
        return establishmentService.addEstablishments(establishments);
    }

    @PatchMapping("/Establishment/{id}")
    public Establishment update(@PathVariable int id, @RequestBody Map<String,String> newEstablishment){
        return establishmentService.updateEstablishment(id, newEstablishment);
    }
}
