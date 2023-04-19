package com.project.vetrepository.repository;

import com.project.vetrepository.dto.AppointmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentDTO, Long> {
    @Query("SELECT a FROM AppointmentDTO a WHERE a.client.client_id=:clientId AND a.date>=:now ORDER BY a.date asc LIMIT :maxCount")
    List<AppointmentDTO> getAppointmentsLimited(@Param("clientId") Long id, @Param("now")LocalDateTime now, @Param("maxCount") Integer maxCount);

    @Query("SELECT a FROM AppointmentDTO a WHERE a.client.client_id=:clientId AND a.date>=:now ORDER BY a.date asc")
    List<AppointmentDTO> getAppointments(@Param("clientId") Long id, @Param("now")LocalDateTime now);
}
