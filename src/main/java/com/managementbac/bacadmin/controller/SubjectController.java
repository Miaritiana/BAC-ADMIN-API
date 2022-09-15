package com.managementbac.bacadmin.controller;

import com.managementbac.bacadmin.model.Subject;
import com.managementbac.bacadmin.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/Subjects")
    public List<Subject> allSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping ("/Subject/{id}")
    public Optional<Subject> findSubject(@PathVariable int id){
        return subjectService.getSubjectById(id);
    }

    @PostMapping("/Subjects")
    public List<Subject> addSubjects(@RequestBody List<Subject> subject){
        return subjectService.addSubjects(subject);
    }

    @PutMapping("/Subject/{id}")
    public Subject update(@PathVariable int id,@RequestBody Subject subject){
        return subjectService.updateSubject(id, subject);
    }
}
