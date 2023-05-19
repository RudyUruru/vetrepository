package com.project.vetrepository.service;

import com.project.vetrepository.dto.AppointmentDTO;
import com.project.vetrepository.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepo appointmentRepo;
    public List<AppointmentDTO> getAppointments(Long id, Long petId, Integer maxCount) {
        List<AppointmentDTO> list;
        if (maxCount == null)
            maxCount = Integer.MAX_VALUE;
        list = appointmentRepo.getAppointmentsLimited(id, petId, LocalDateTime.now(), maxCount);


        return list;
    }
}
