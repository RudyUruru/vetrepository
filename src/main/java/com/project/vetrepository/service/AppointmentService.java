package com.project.vetrepository.service;

import com.project.vetrepository.dto.AppointmentDTO;
import com.project.vetrepository.dto.AppointmentType;
import com.project.vetrepository.repository.AppointmentRepo;
import com.project.vetrepository.repository.ClientRepo;
import com.project.vetrepository.repository.ManipulationRepo;
import com.project.vetrepository.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private static final int INTERVAL = 20;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private ManipulationRepo manipulationRepo;

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

    public Boolean makeAppointment(String email,
                                   Long petId,
                                   LocalDateTime date,
                                   Long surgeonId,
                                   AppointmentType type) {
        if (appointmentRepo.getByDate(date).isEmpty()) {
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            appointmentDTO.setClient(clientRepo.findByEmail(email));
            appointmentDTO.setPet(petRepo.findSimpleById(petId));
            appointmentDTO.setDate(date);
            appointmentDTO.setType(type);
            appointmentDTO.setDescription(manipulationRepo.findById(surgeonId).orElseThrow().getName());
            appointmentDTO.setDoctor_name("Петров Иван Сергеевич");
            appointmentRepo.save(appointmentDTO);
            return true;
        } else {
            return false;
        }
    }
}
