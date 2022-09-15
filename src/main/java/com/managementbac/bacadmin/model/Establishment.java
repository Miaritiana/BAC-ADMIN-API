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
@Entity(name = "establishment")
public class Establishment {
    @Id
    @Column(name = "id_establishment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEstablishment;
    @Column(name = "establishment")
    private String establishment;
}
