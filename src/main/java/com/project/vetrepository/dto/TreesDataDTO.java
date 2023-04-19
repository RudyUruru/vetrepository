package com.project.vetrepository.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trees_data")
@Getter
@Setter
@NoArgsConstructor
public class TreesDataDTO {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private String value;

}
