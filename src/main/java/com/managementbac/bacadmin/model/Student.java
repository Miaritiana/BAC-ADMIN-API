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
import javax.persistence.ManyToOne;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Entity(name = "student")
public class Student {
    @Id
    @Column(name = "id_student")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudent;
    @Column(name = "name")
    private String name;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "adress")
    private String adress;
    @Column(name = "gender")
    private String gender;
    @Column(name = "year")
    private int year;
    @ManyToOne
    private Serie serie;
    @ManyToOne
    private Establishment establishment;
    @ManyToOne
    private ExaminationCenter examinationCenter;
}
