package com.project.vetrepository.controller;

import com.project.vetrepository.dto.AppointmentType;
import com.project.vetrepository.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/make_appointment")
    public ResponseEntity makeAppointment(@RequestParam String email,
                                          @RequestParam("pet_id") Long petId,
                                          @RequestParam LocalDateTime date,
                                          @RequestParam("surgeon_id") Long surgeonId,
                                          @RequestParam AppointmentType type) {
        if (appointmentService.makeAppointment(email, petId, date, surgeonId, type))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().body("Это время занято");
    }
}
