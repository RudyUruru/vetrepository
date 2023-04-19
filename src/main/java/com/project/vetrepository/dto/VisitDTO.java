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
    private PetDTO pet;

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

    @JsonIgnoreProperties({"visit", "pet"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visit")
    private List<XPetsDiagsDTO> diagnoses;

}