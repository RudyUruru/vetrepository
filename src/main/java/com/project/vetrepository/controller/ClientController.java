package com.project.vetrepository.controller;


import com.project.vetrepository.UserInfo;
import com.project.vetrepository.dto.AppointmentDTO;
import com.project.vetrepository.dto.ClientDTO;
import com.project.vetrepository.dto.VisitDTO;
import com.project.vetrepository.service.AppointmentService;
import com.project.vetrepository.service.ClientService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAppointments(/*@RequestParam Long id,*/ @Nullable @RequestParam Integer max_count) {
        return ResponseEntity.ok(appointmentService.getAppointments(UserInfo.ID, max_count));
    }


    @GetMapping("/client_info")
    public ResponseEntity<ClientDTO> getClientFullName(/*@RequestParam Long id*/) {
        return ResponseEntity.ok(clientService.getClientInfo(UserInfo.ID));
    }


    //Можно добавить в фильтры еще одну дату и искать между ними
    @GetMapping("/visits")
    public ResponseEntity<List<VisitDTO>> getVisits(/*@RequestParam Long id,*/
                                                    @RequestParam @Nullable Long kind_id,
                                                    @RequestParam @Nullable Long breed_id,
                                                    @RequestParam @Nullable LocalDateTime date1, @RequestParam @Nullable LocalDateTime date2,
                                                    @RequestParam @Nullable Integer max_count) {
        List<VisitDTO> visits = clientService.getVisits(UserInfo.ID, kind_id, breed_id, date1, date2, max_count);
        return ResponseEntity.ok(visits);
    }
}
