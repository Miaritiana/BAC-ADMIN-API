package com.managementbac.bacadmin.service;

import com.managementbac.bacadmin.model.Exam;
import com.managementbac.bacadmin.model.SerieSubject;
import com.managementbac.bacadmin.model.Student;
import com.managementbac.bacadmin.repository.ExamRepository;
import com.managementbac.bacadmin.repository.StudentRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Data
public class ExamService {

    private final ExamRepository examRepository;
    private final StudentRepository studentRepository;

    private final SerieSubjectService serieSubjectService;

    public List<Exam> getAllExamResultsById(int id){
        List<Exam> exams = examRepository.findAll();
        List<Exam> examsById = new ArrayList<>();
        for (Exam exam:exams){
            if(exam.getStudent().getIdStudent() == id) {
                examsById.add(exam);
            }
        }
        return examsById;
    }

    public List<List<Exam>> getAllExamResults(){
        List<List<Exam>> listsResult = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (int i = 0; i < studentList.size(); i++) {
            listsResult.add(getAllExamResultsById(studentList.get(i).getIdStudent()));
        }
        return listsResult;
    }

    public List<Exam> addMarkExams(List<Exam> exam){
        return examRepository.saveAll(exam);
    }

    public Map<String,Double> getAllMarkByIdStudent(int id){
        List<Exam> examResultListsById = getAllExamResultsById(id);
        Map<String,Double> studentMark = new HashMap<>();
        for (Exam examResult:examResultListsById){
            studentMark.put(
                    examResult.getSubject().getDescription(),
                    examResult
                            .getMark()*serieSubjectService
                                                .getSerieSubjectByIdSubject
                                                        (examResult
                                                                .getSubject()
                                                                .getIdSubject()
                                                        ).get(0).getCoefficient()
            );
        }
        return studentMark;
    }

    public Map<String,Double> getResultByIdStudent(int id){
        Map<String,Double> studentMarkPerSubject = getAllMarkByIdStudent(id);
        Map<String,Double> candidateResult = new HashMap<>();
        List<Exam> examResultListsById = getAllExamResultsById(id);
        Double total = 0.00;
        int totalCoefficient = 0;
        Double average = 0.00;
        for (String subject: studentMarkPerSubject.keySet()){
            candidateResult.put(subject,studentMarkPerSubject.get(subject));
        }
        for (String subjectName: studentMarkPerSubject.keySet()){
            total += studentMarkPerSubject.get(subjectName);
        }
        for (Exam examResult: examResultListsById){
            totalCoefficient += serieSubjectService
                                    .getSerieSubjectByIdSubject
                                            (examResult
                                                    .getSubject()
                                                    .getIdSubject()
                                            ).get(0).getCoefficient();
        }

        candidateResult.put("Total",total);

        average = total/totalCoefficient;

        candidateResult.put("Average",average);

        candidateResult.put("idStudent", (double) id);

        return candidateResult;
    }

    public List<Map<String,Double>> getAllResult(){
        List<Student> allCandidates = studentRepository.findAll();
        List<Map<String,Double>> allResults = new ArrayList<>();
        for (Student Candidate:allCandidates){
            allResults.add(getResultByIdStudent(Candidate.getIdStudent()));
        }
        return allResults;
    }
}
