package com.project.vetrepository.repository;

import ch.qos.logback.core.net.server.Client;
import com.project.vetrepository.dto.ClientDTO;
import com.project.vetrepository.dto.ClientLightDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ClientRepo extends JpaRepository<ClientLightDTO, Long> {
    ClientLightDTO findByEmail(String email);

    @Query("SELECT c FROM ClientLightDTO c WHERE c.client_id=:id")
    ClientLightDTO findByClientId(@Param("id")Long id);
}
