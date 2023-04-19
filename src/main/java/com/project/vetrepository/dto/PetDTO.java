package com.project.vetrepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pets")
@Getter
@Setter
public class PetDTO {

    @Id
    @Column(name = "id")
    private Long pet_id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "breed")
    private BreedDataDTO breed;

    @ManyToOne
    @JoinColumn(name = "sex")
    private DictionariesDataDTO sex;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name = "sterilized")
    private Short sterilized;

    @ManyToOne
    @JoinColumn(name = "kind")
    private TreesDataDTO kind;

    @ManyToOne
    @JoinColumn(name = "color")
    private DictionariesDataDTO color;


    @JsonIgnoreProperties({"pets", "appointments", "visits"})
    @ManyToOne
    @JoinColumn (name = "client_id")
    private ClientDTO owner;

    @JsonIgnoreProperties({"client", "pet"})
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "pet")
    private List<AppointmentDTO> appointments;

    @JsonIgnoreProperties({"client", "pet", "diagnoses"})
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "pet")
    private List<VisitDTO> visits;

    @JsonIgnoreProperties("pet")
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "pet")
    private List<XPetsDiagsDTO> diagnoses;
}
