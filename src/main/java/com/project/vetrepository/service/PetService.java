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

    public List<PetLightDTO> getPets(Long id, Long kind_id, Long breed_id, Integer maxCount) {
        List<PetLightDTO> list;
        if (maxCount == null)
            maxCount = Integer.MAX_VALUE;
        if (maxCount == null && breed_id == null)
            list = petRepo.findPets(id, kind_id);
        else if (maxCount == null)
            list = petRepo.findPetsByBreed(id, kind_id, breed_id);
        else if (breed_id == null)
            list = petRepo.findPetsLimited(id, kind_id, maxCount);
        else
            list = petRepo.findPetsLimitedWithBreed(id, kind_id, breed_id, maxCount);
        return list;
    }

    public List<PetLightDTO> getPetsByName(Long id, String name) {
        return petRepo.findByName(id, name);
    }
}
