package com.managementbac.bacadmin.repository;

import com.managementbac.bacadmin.model.SerieSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieSubjectRepository extends JpaRepository<SerieSubject, Integer> {

}
