package com.project.vetrepository.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "breed_data")
@Getter
@Setter
@NoArgsConstructor
public class BreedDataDTO {

    @Id
    @Column(name = "id")
    private Long breed_id;

    @Column(name = "value")
    private String value;
}

