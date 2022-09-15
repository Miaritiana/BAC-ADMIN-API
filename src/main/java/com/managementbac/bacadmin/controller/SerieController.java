package com.managementbac.bacadmin.controller;

import com.managementbac.bacadmin.model.Serie;
import com.managementbac.bacadmin.service.SerieService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Data
public class SerieController {
    private final SerieService serieService;

    @GetMapping("/Series")
    public List<Serie> allSeries(){
        return serieService.getAllSeries();
    }

    @GetMapping("/Serie/{id}")
    public Optional<Serie> findSerie(@PathVariable int id){
        return serieService.getSerieById(id);
    }

    @PostMapping("/Series")
    public List<Serie> addSeries(@RequestBody List<Serie> serie){
        return serieService.addSeries(serie);
    }

    @DeleteMapping("/Serie/{id}")
    public String deleteSerie(@PathVariable int id){
        serieService.deleteSerieById(id);
        return "serie deleted successfully";
    }

    @PutMapping("/Serie/{id}")
    public Serie update(@PathVariable int id,@RequestBody Serie newSerie){
        return serieService.updateSerie(id, newSerie);
    }
}
