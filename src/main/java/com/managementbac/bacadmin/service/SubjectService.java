package com.managementbac.bacadmin.service;

import com.managementbac.bacadmin.model.Subject;
import com.managementbac.bacadmin.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(int id){
        return subjectRepository.findById(id);
    }

    public List<Subject> addSubjects(List<Subject> subject){
        return subjectRepository.saveAll(subject);
    }

    public Subject updateSubject(int id, Subject subjectObj){
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()){
            subject.get().setDescription(subjectObj.getDescription());
            return subjectRepository.save(subject.get());
        } else {
            return null;
        }
    }
}
