package com.project.vetrepository.dto;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private TreesDataDTO diagnosis_type;

}
