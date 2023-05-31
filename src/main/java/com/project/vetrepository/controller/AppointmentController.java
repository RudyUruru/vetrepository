package com.project.vetrepository.controller;

import com.project.vetrepository.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @GetMapping("/get_free_time")
    public ResponseEntity<List<LocalDateTime>> getFreeTime(@RequestParam("doctor_id") Long doctorId, @RequestParam LocalDateTime date) {
        return ResponseEntity.ok(appointmentService.getFreeTime(doctorId, date));
    }

    @PostMapping("make_appointment")
    public ResponseEntity makeAppointment(@RequestParam("pet_id") Long petId,
                                          @RequestParam("client_name") String clientName,
                                          @RequestParam String email,
                                          @RequestParam LocalDateTime date,
                                          @RequestParam("surgeon_id") Long surgeonId,
                                          @RequestParam("doctor_id") Long doctorId) {
        return ResponseEntity.ok().build();
    }
}
