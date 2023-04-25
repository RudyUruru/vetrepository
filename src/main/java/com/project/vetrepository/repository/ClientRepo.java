package com.project.vetrepository.repository;

import com.project.vetrepository.dto.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<ClientDTO, Long> {
    ClientDTO findByEmail(String email);
}
