package com.project.vetrepository.service;

import com.project.vetrepository.dto.BreedDataDTO;
import com.project.vetrepository.dto.PetLightDTO;
import com.project.vetrepository.dto.TreesDataDTO;
import com.project.vetrepository.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FiltersService {
    //TODO связать фильтры породы и вида, чтобы при выборе определенного вида передавались породы только для него
    @Autowired
    PetRepo petRepo;

    public Set<BreedDataDTO> getBreeds(Long id, Long kindId) {
        List<PetLightDTO> pets;
        pets = petRepo.findAllHaveBreed(id, kindId);
        Set<BreedDataDTO> filter = new HashSet<>();
        for (PetLightDTO p : pets) {
            filter.add(p.getBreed());
        }
        return filter;
    }
    public Set<TreesDataDTO> getKinds(Long id, Long breedId) {
        List<PetLightDTO> pets = petRepo.findPetsFullFiltered(id, null, breedId, null, Integer.MAX_VALUE);
        Set<TreesDataDTO> filter = new HashSet<>();
        for (PetLightDTO p : pets) {
            filter.add(p.getKind());
        }
        return filter;
    }
}
