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
@Entity(name = "serie_subject")
public class SerieSubject {
    @Id
    private int id_seriesubject;
    @Column(name = "coefficient")
    private int coefficient;
    @ManyToOne
    private Serie serie;
    @ManyToOne
    private Subject subject;
}
