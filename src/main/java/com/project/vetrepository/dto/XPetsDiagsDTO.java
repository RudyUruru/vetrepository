package com.project.vetrepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "x_pet_diags")
@IdClass(XPetDiagsCompositeKey.class)
@Getter
@Setter
public class XPetsDiagsDTO {
    @JsonIgnoreProperties({"owner", "visits", "appointments", "diagnoses"})
    @Id
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetDTO pet;

    @JsonIgnoreProperties({"client", "pet", "diagnoses"})
    @Id
    @ManyToOne
    @JoinColumn(name = "visit_id")
    private VisitDTO visit;

    @Id
    @ManyToOne
    @JoinColumn(name = "diag_id")
    private DiagnosesDTO diagnosis;

    public XPetsDiagsDTO() {
    }
}
