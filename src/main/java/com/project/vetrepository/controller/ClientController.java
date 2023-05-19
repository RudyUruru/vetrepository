package com.project.vetrepository.controller;


import com.project.vetrepository.UserInfo;
import com.project.vetrepository.dto.AppointmentDTO;
import com.project.vetrepository.dto.ClientDTO;
import com.project.vetrepository.dto.ClientLightDTO;
import com.project.vetrepository.dto.VisitDTO;
import com.project.vetrepository.repository.ClientRepo;
import com.project.vetrepository.service.AppointmentService;
import com.project.vetrepository.service.ClientService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v2")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAppointments(@RequestParam String email,
                                                                @RequestParam @Nullable Long petId,
                                                                @RequestParam @Nullable Integer max_count) {
        ClientLightDTO client = clientRepo.findByEmail(email);
        return ResponseEntity.ok(appointmentService.getAppointments(client.getClient_id(), petId, max_count));
    }


    @GetMapping("/client_info")
    public ResponseEntity<ClientLightDTO> getClientFullName(@RequestParam String email) {
        ClientLightDTO client = clientRepo.findByEmail(email);
        return ResponseEntity.ok(clientService.getClientInfo(client.getClient_id()));
    }


    @GetMapping("/visits")
    public ResponseEntity<List<VisitDTO>> getVisits(@RequestParam String email,
                                                    @RequestParam @Nullable Long petId,
                                                    @RequestParam @Nullable Long kind_id,
                                                    @RequestParam @Nullable Long breed_id,
                                                    @RequestParam @Nullable LocalDateTime date1, @RequestParam @Nullable LocalDateTime date2,
                                                    @RequestParam @Nullable Integer max_count) {
        ClientLightDTO client = clientRepo.findByEmail(email);
        List<VisitDTO> visits = clientService.getVisits(client.getClient_id(), petId, kind_id, breed_id, date1, date2, max_count);
        return ResponseEntity.ok(visits);
    }
}
