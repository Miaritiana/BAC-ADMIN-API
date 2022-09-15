package com.managementbac.bacadmin.repository;

import com.managementbac.bacadmin.model.ExaminationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationCenterRepository extends JpaRepository<ExaminationCenter, Integer> {
}
