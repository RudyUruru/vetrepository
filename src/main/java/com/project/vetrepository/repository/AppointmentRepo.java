package com.project.vetrepository.repository;

import com.project.vetrepository.dto.AppointmentDTO;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentDTO, Long> {
    @Query("SELECT a FROM AppointmentDTO a WHERE a.client.client_id=:clientId " +
            " AND (:petId IS NULL OR a.pet.pet_id=:petId)" +
            " AND a.date>=:now" +
            " ORDER BY a.date asc LIMIT :maxCount")
    List<AppointmentDTO> getAppointmentsLimited(@Param("clientId") Long id,
                                                @Nullable @Param("petId") Long petId,
                                                @Param("now")LocalDateTime now,
                                                @Param("maxCount") Integer maxCount);

    Optional<AppointmentDTO> getByDate(LocalDateTime date);

}
