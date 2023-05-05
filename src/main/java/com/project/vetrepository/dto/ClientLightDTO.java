package com.project.vetrepository.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
