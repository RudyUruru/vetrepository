package com.project.vetrepository.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="configuration")
@Getter
@Setter
public class ConfigurationDTO {
    @Id
    @Column(name="name")
    private String name;

    @Column(name="value")
    private String value;
}
