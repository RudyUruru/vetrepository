package com.project.vetrepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {
    @Id
    @Column(name = "id")
    private Long appointment_id;

    @JsonIgnoreProperties("owner")
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetLightDTO pet;

    @JsonIgnoreProperties({"appointments", "pets", "visits"})
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientDTO client;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "value")
    private String value;

    @Column(name = "doc")
    private String doctor_name;
}
