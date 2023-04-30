package com.project.vetrepository.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visit_types")
@Getter
@Setter
@NoArgsConstructor
public class VisitType {
    @Id
    @Column(name = "id")
    private Long type_id;

    @Column(name = "value")
    private String type_name;

}
