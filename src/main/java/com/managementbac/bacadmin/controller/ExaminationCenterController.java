package com.managementbac.bacadmin.controller;

import com.managementbac.bacadmin.model.ExaminationCenter;
import com.managementbac.bacadmin.service.ExaminationCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ExaminationCenterController {
    private final ExaminationCenterService examinationCenterService;

    @GetMapping("/ExaminationCenters")
    public List<ExaminationCenter> allExaminationCenter(){
        return examinationCenterService.getAllExaminationCenter();
    }

    @PostMapping("/ExaminationCenters")
    public List<ExaminationCenter> addExaminationCenter(@RequestBody List<ExaminationCenter> examinationCenters){
        return examinationCenterService.addExaminationCenter(examinationCenters);
    }

    @PatchMapping("/ExaminationCenter/{id}")
    public ExaminationCenter update(@PathVariable int id, @RequestBody Map<String,String> newVenue){
        return examinationCenterService.updateExaminationCenter(id, newVenue);
    }
}
