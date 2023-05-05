package com.project.vetrepository.controller;

import com.project.vetrepository.UserInfo;
import com.project.vetrepository.dto.BreedDataDTO;
import com.project.vetrepository.dto.ClientDTO;
import com.project.vetrepository.dto.ClientLightDTO;
import com.project.vetrepository.dto.TreesDataDTO;
import com.project.vetrepository.repository.ClientRepo;
import com.project.vetrepository.service.FiltersService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v3")
public class FilterController {

    @Autowired
    FiltersService filtersService;

    @Autowired
    ClientRepo clientRepo;

    @GetMapping("/all_breeds")
    public ResponseEntity<Set<BreedDataDTO>> getBreedFilter(@RequestParam String email, @Nullable @RequestParam Long kind_id) {
        ClientLightDTO client = clientRepo.findByEmail(email);
        Set<BreedDataDTO> breeds = filtersService.getBreeds(client.getClient_id(), kind_id);
        return ResponseEntity.ok(breeds);
    }

    @GetMapping("/all_kinds")
    public ResponseEntity<Set<TreesDataDTO>> getKindFilter(@RequestParam String email, @Nullable @RequestParam Long breed_id) {
        ClientLightDTO client = clientRepo.findByEmail(email);
        Set<TreesDataDTO> kinds = filtersService.getKinds(client.getClient_id(), breed_id);
        return ResponseEntity.ok(kinds);
    }
}