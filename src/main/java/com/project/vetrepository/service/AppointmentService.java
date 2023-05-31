package com.project.vetrepository.service;

import com.project.vetrepository.dto.AppointmentDTO;
import com.project.vetrepository.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private static final int INTERVAL = 20;
    @Autowired
    AppointmentRepo appointmentRepo;
    public List<AppointmentDTO> getAppointments(Long id, Long petId, Integer maxCount) {
        List<AppointmentDTO> list;
        if (maxCount == null)
            maxCount = Integer.MAX_VALUE;
        list = appointmentRepo.getAppointmentsLimited(id, petId, LocalDateTime.now(), maxCount);
        return list;
    }

    public List<LocalDateTime> getFreeTime(Long manipulation_id, LocalDateTime date) {
        List<LocalDateTime> freeTimeList = new ArrayList<>();
        if (date.isBefore(LocalDateTime.now()))
            return freeTimeList;
        LocalDateTime beginOfTheWorkDay = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 10, 0);
        LocalDateTime endOfTheWorkDay = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 22, 0);
        for (LocalDateTime i = beginOfTheWorkDay; i.isBefore(endOfTheWorkDay); i = i.plusMinutes(INTERVAL)) {
            if (appointmentRepo.getByDate(i).isEmpty()) {
                freeTimeList.add(i);
            }
        }
        return freeTimeList;
    }
}
