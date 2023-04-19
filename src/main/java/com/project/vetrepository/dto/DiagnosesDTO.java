package com.project.vetrepository.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "diagnoses")
@Getter
@Setter
@NoArgsConstructor
public class DiagnosesDTO {
    @Id
    @Column(name = "id")
    private Long diagnosis_id;

    @Column(name = "name")
    private String diagnosis_name;
}
