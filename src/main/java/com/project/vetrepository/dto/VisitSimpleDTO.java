package com.project.vetrepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class VisitSimpleDTO {
    @Id
    @Column(name = "id")
    private Long visit_id;


    @Column(name = "pet_id")
    private Long petId;

    @Column(name = "client_id")
    private Long clientId;

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

    @Column(name = "weight")
    private String weight;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "heart_beat")
    private String heartBeat;

    @Column(name = "breath_beat")
    private String breathBeat;

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private DictionariesDataDTO vaccine;

    @Column(name = "next_vaccination")
    private LocalDateTime nextVaccination;

}
