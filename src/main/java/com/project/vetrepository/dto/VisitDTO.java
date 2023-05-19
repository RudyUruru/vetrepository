package com.project.vetrepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
public class VisitDTO {
    @Id
    @Column(name = "id")
    private Long visit_id;


    @JsonIgnoreProperties({"owner", "visits", "appointments", "diagnoses"})
    @ManyToOne
    @JoinColumn (name = "pet_id")
    private PetLightDTO pet;

    @JsonIgnoreProperties({"pets", "appointments", "visits"})
    @ManyToOne
    @JoinColumn (name = "client_id")
    private ClientDTO client;

    @Column (name = "rec_changed")
    private LocalDateTime date;

    @Column (name = "anamnesis")
    private String anamnesis;

    @Column (name = "prescription")
    private String prescription;

    @Column (name = "recommend")
    private String recommendation;

    @Column(name = "type_id")
    private Integer type;

    @Column(name = "first_visit_id")
    private Long first_visit_id;

    @JsonIgnoreProperties({"visit", "pet"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visit")
    private List<XPetsDiagsDTO> diagnoses;

    @Column(name = "weight")
    private String weight;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "heart_beat")
    private String heartBeat;

    @Column(name = "breath_beat")
    private String breathBeat;

    @Column(name = "vaccine_id")
    private Long vaccineId;

    @Column(name = "next_vaccination")
    private LocalDateTime nextVaccination;
}