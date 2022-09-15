package com.managementbac.bacadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Entity(name = "exam")
public class Exam {
    @Id
    private int id_exam;
    @Column(name = "mark")
    private double mark;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Subject subject;
}
