package com.project.vetrepository.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dictionaries_data")
@Getter
@Setter
public class DictionariesDataDTO {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private String value;

    public DictionariesDataDTO() {}

}
