package com.managementbac.bacadmin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Entity(name = "examination_center")
public class ExaminationCenter {
    @Id
    @Column(name = "id_center")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCenter;
    @Column(name = "venue")
    private String venue;
}
