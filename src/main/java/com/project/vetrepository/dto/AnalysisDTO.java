package com.project.vetrepository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "analysis")
@Getter
@Setter
@NoArgsConstructor
public class AnalysisDTO {
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetLightDTO pet;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    private VisitSimpleDTO visit;

    @Column(name = "analysis_name")
    private String analysisName;

    @Column(name = "is_ready")
    private boolean isReady;

    @Column(name = "date")
    private LocalDateTime date;

}
