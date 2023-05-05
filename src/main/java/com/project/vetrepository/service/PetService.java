package com.project.vetrepository.service;

import com.project.vetrepository.dto.PetLightDTO;
import com.project.vetrepository.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PetService {

    @Autowired
    PetRepo petRepo;

    public List<PetLightDTO> getPets(Long id, Long kind_id, Long breed_id, String name, Integer maxCount) {
        if (maxCount == null) {
            maxCount = Integer.MAX_VALUE;
        }
        return petRepo.findPetsFullFiltered(id, kind_id, breed_id, name, maxCount);
    }
}
