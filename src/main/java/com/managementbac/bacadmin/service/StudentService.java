package com.managementbac.bacadmin.service;

import com.managementbac.bacadmin.model.Student;
import com.managementbac.bacadmin.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public List<Student> getAllCandidates(){
        return studentRepository.findAll();
    }
    public Optional<Student> getCandidateById(int id){
        return studentRepository.findById(id);
    }
    public void deleteCandidateById(int id){
        studentRepository.deleteById(id);
    }
    public List<Student> addCandidate(List<Student> student){
        return studentRepository.saveAll(student);
    }

    public Student updateStudent(int id, Student newInfo){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            if(newInfo.getName() == null){
                student.get().setName(student.get().getName());
            } else {
                student.get().setName(newInfo.getName());
            }
            if (newInfo.getFirstName() == null){
                student.get().setFirstName(student.get().getFirstName());
            } else {
                student.get().setFirstName(newInfo.getFirstName());
            }
            if (newInfo.getGender() == null){
                student.get().setGender(student.get().getGender());
            } else {
                student.get().setGender(newInfo.getGender());
            }
            if (newInfo.getAdress() == null) {
                student.get().setAdress(student.get().getAdress());
            } else {
                student.get().setAdress(newInfo.getAdress());
            }
            if (newInfo.getBirthday() == null){
                student.get().setBirthday(student.get().getBirthday());
            } else {
                student.get().setBirthday(newInfo.getBirthday());
            }
            if (newInfo.getYear() == 0){
                student.get().setYear(student.get().getYear());
            } else {
                student.get().setYear(newInfo.getYear());
            }
            if (newInfo.getSerie() == null){
                student.get().setSerie(student.get().getSerie());
            } else {
                student.get().setSerie(newInfo.getSerie());
            }
            if (newInfo.getEstablishment() == null){
                student.get().setEstablishment(student.get().getEstablishment());
            } else {
                student.get().setEstablishment(newInfo.getEstablishment());
            }
            if (newInfo.getExaminationCenter() == null){
                student.get().setExaminationCenter(student.get().getExaminationCenter());
            } else {
                student.get().setExaminationCenter(newInfo.getExaminationCenter());
            }
            return studentRepository.save(student.get());
        } else {
            return null;
        }
    }
}
