package com.project.vetrepository.controller;

import com.project.vetrepository.UserInfo;
import com.project.vetrepository.dto.BreedDataDTO;
import com.project.vetrepository.dto.TreesDataDTO;
import com.project.vetrepository.service.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v3")
public class FilterController {

    @Autowired
    FiltersService filtersService;

    @GetMapping("/all_breeds")
    public ResponseEntity<Set<BreedDataDTO>> getBreedFilter(/*@RequestParam Long id*/) {
        Set<BreedDataDTO> breeds = filtersService.getBreeds(UserInfo.ID);
        return ResponseEntity.ok(breeds);
    }

    @GetMapping("/all_kinds")
    public ResponseEntity<Set<TreesDataDTO>> getKindFilter(/*@RequestParam Long id*/) {
        Set<TreesDataDTO> kinds = filtersService.getKinds(UserInfo.ID);
        return ResponseEntity.ok(kinds);
    }
}