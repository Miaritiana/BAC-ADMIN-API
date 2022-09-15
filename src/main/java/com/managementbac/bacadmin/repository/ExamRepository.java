package com.managementbac.bacadmin.repository;

import com.managementbac.bacadmin.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
