package com.project.vetrepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class ClientLightDTO {
    @Id
    @Column(name = "id")
    private Long client_id;

    @Column(name = "fname")
    private String first_name;

    @Column(name = "mname")
    private String middle_name;

    @Column(name = "sname")
    private String sur_name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
}
