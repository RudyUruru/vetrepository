package com.project.vetrepository.controller;

import com.project.vetrepository.UserInfo;
import com.project.vetrepository.dto.ClientDTO;
import com.project.vetrepository.dto.ClientLightDTO;
import com.project.vetrepository.dto.PetLightDTO;
import com.project.vetrepository.repository.ClientRepo;
import com.project.vetrepository.service.PetService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class PetController {
    @Autowired
    PetService petService;

    @Autowired
    ClientRepo clientRepo;
    //посмотреть
    @GetMapping("/pets")
    public ResponseEntity<List<PetLightDTO>> getPetsFiltered(@RequestParam String email,
                                                                @RequestParam @Nullable Long kind_id,
                                                                @RequestParam @Nullable Long breed_id,
                                                                @RequestParam @Nullable String name,
                                                                @RequestParam @Nullable Integer max_count) {
        ClientLightDTO client = clientRepo.findByEmail(email);
        return ResponseEntity.ok(petService.getPets(client.getClient_id(), kind_id, breed_id, name, max_count));
    }

}
