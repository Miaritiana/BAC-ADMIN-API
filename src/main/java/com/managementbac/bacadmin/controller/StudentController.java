package com.managementbac.bacadmin.controller;

import com.managementbac.bacadmin.model.Student;
import com.managementbac.bacadmin.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;
   @GetMapping("/Candidats")
    public List<Student> AllCandidates(){
        return studentService.getAllCandidates();
    }

    @GetMapping("/Candidate/{id}")
    public Optional<Student> findCandidate(@PathVariable int id){
        return studentService.getCandidateById(id);
    }

    @PostMapping("/Candidats")
    public List<Student> addCandidate(@RequestBody List<Student> student){
        return studentService.addCandidate(student);
    }

    @DeleteMapping("Candidate/{id}")
    public String deleteCandidateById(@PathVariable int id){
        studentService.deleteCandidateById(id);
        return "Candidate deleted successfully";
    }

    @PatchMapping("/Candidate/{id}")
    public Student update(@PathVariable int id, @RequestBody Student newInfo){
       return studentService.updateStudent(id, newInfo);
    }
}
