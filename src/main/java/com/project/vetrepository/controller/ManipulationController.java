package com.project.vetrepository.controller;

import com.project.vetrepository.dto.ManipulationDTO;
import com.project.vetrepository.service.ManipulationService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ManipulationController {

    @Autowired
    ManipulationService manipulationService;
    @GetMapping("/get_surgeons")
    public ResponseEntity<List<ManipulationDTO>> getSurgeons(@Nullable @RequestParam String name) {
        return ResponseEntity.ok(manipulationService.getManipulations(name));
    }
}
