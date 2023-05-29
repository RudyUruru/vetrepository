package com.project.vetrepository.service;

import com.project.vetrepository.dto.ManipulationDTO;
import com.project.vetrepository.repository.ManipulationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManipulationService {
    @Autowired
    private ManipulationRepo manipulationRepo;

    public List<ManipulationDTO> getManipulations(String name) {
        return manipulationRepo.getManipulations(name);
    }
}
