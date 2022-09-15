package com.managementbac.bacadmin.service;

import com.managementbac.bacadmin.model.SerieSubject;
import com.managementbac.bacadmin.repository.SerieSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SerieSubjectService {
    private final SerieSubjectRepository serieSubjectRepository;

    public List<SerieSubject> getAllSerieSubject(){
        return serieSubjectRepository.findAll();
    }

    public List<SerieSubject> getSerieSubjectByIdSubject(int id){
        List<SerieSubject> serieSubjects = serieSubjectRepository.findAll();
        List<SerieSubject> serieSubjectsByIdSubject = new ArrayList<>();
        for(SerieSubject serieSubject:serieSubjects){
            if (serieSubject.getSubject().getIdSubject() == id){
                serieSubjectsByIdSubject.add(serieSubject);
            }
        }
        return serieSubjectsByIdSubject;
    }

    public List<SerieSubject> addCoefficientToSubjects(List<SerieSubject> serieSubjects){
        return serieSubjectRepository.saveAll(serieSubjects);
    }

    public SerieSubject updateCoefficientOfSubject(int id, Map<String,Integer> newCoefficient){
        Optional<SerieSubject> serieSubject = serieSubjectRepository.findById(id);

        if (serieSubject.isPresent()){
            serieSubject.get().setCoefficient(newCoefficient.get("coefficient"));
            return serieSubjectRepository.save(serieSubject.get());
        } else {
            return null;
        }
    }
}
