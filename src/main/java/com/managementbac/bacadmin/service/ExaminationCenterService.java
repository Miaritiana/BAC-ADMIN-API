package com.managementbac.bacadmin.service;

import com.managementbac.bacadmin.model.ExaminationCenter;
import com.managementbac.bacadmin.repository.ExaminationCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExaminationCenterService {
    private final ExaminationCenterRepository examinationCenterRepository;

    public List<ExaminationCenter> getAllExaminationCenter(){
        return examinationCenterRepository.findAll();
    }

    public List<ExaminationCenter> addExaminationCenter(List<ExaminationCenter> examinationCenters){
        return examinationCenterRepository.saveAll(examinationCenters);
    }

    public ExaminationCenter updateExaminationCenter(int id, Map<String,String> newVenue){
        Optional<ExaminationCenter> examinationCenter = examinationCenterRepository.findById(id);
        if(examinationCenter.isPresent()){
            examinationCenter.get().setVenue(newVenue.get("venue"));
            return examinationCenterRepository.save(examinationCenter.get());
        } else {
            return null;
        }
    }
}
