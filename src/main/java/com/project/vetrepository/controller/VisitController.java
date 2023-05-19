package com.project.vetrepository.controller;

import com.project.vetrepository.UserInfo;
import com.project.vetrepository.dto.VisitDTO;
import com.project.vetrepository.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v4")
public class VisitController {
    @Autowired
    VisitService visitService;

    @GetMapping("/visit")
    public ResponseEntity<VisitDTO> getVisit(@RequestParam Long visit_id) {
        return ResponseEntity.ok(visitService.getVisit(visit_id));
    }
}
