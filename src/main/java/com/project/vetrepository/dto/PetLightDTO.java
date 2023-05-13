package com.project.vetrepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class PetLightDTO {
    @Id
    @Column(name = "id")
    private Long pet_id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "breed")
    private BreedDataDTO breed;

    @ManyToOne
    @JoinColumn(name = "kind")
    private TreesDataDTO kind;

    @Column(name = "chip")
    private String chipNumber;

    @ManyToOne
    @JoinColumn(name = "sex")
    private DictionariesDataDTO sex;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @JsonInclude
    @Column(name = "sterilized")
    private Short sterilized;

    @JsonIgnoreProperties({"pets", "appointments", "visits"})
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientDTO owner;

    @ManyToOne
    @JoinColumn(name = "color")
    private DictionariesDataDTO color;
}
