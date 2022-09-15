package com.managementbac.bacadmin.controller;

import com.managementbac.bacadmin.model.Exam;
import com.managementbac.bacadmin.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ExamController {
    private final ExamService examService;

    @GetMapping("/Exam/{id}")
    public List<Exam> findExamResultsById(@PathVariable int id){
        return examService.getAllExamResultsById(id);
    }

    @GetMapping("/Exams")
    public List<List<Exam>> allExamResults(){
        return examService.getAllExamResults();
    }

    @PostMapping("/Exams")
    public List<Exam> addMark(@RequestBody List<Exam> exams){
        return examService.addMarkExams(exams);
    }

    @GetMapping("Exam/Mark/{id}")
    public Map<String,Double> findMarkById(@PathVariable int id){
        return examService.getAllMarkByIdStudent(id);
    }

    @GetMapping("/Result/{idStudent}")
    public Map<String, Double> getResultByIdStudent(@PathVariable int idStudent){
        return examService.getResultByIdStudent(idStudent);
    }

    @GetMapping("/Results")
    public List<Map<String,Double>> getAllResult(){
        return examService.getAllResult();
    }
}
