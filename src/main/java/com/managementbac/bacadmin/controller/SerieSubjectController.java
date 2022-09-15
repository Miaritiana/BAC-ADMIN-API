package com.managementbac.bacadmin.controller;

import com.managementbac.bacadmin.model.SerieSubject;
import com.managementbac.bacadmin.service.SerieSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SerieSubjectController {
    private final SerieSubjectService serieSubjectService;

    @GetMapping("/SerieSubjects")
    public List<SerieSubject> getAllSubjectCoefficient(){
        return serieSubjectService.getAllSerieSubject();
    }

    @GetMapping("/SerieSubject/Subject/{idSubject}")
    public List<SerieSubject> findSubjectCoefficientByIdSubject(@PathVariable int idSubject){
        return serieSubjectService.getSerieSubjectByIdSubject(idSubject);
    }

    @PostMapping("/SerieSubjects")
    public List<SerieSubject> addCoefficientToSubject(@RequestBody List<SerieSubject> serieSubjects){
        return serieSubjectService.addCoefficientToSubjects(serieSubjects);
    }

    @PatchMapping("/SerieSubject/{idSerieSubject}")
    public SerieSubject updateCoefficientOfSubject(@PathVariable int idSerieSubject, @RequestBody Map<String,Integer> newCoefficient){
        return serieSubjectService.updateCoefficientOfSubject(idSerieSubject, newCoefficient);
    }
}
