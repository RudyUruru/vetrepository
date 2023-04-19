package com.project.vetrepository.service;

import com.project.vetrepository.dto.VisitDTO;
import com.project.vetrepository.repository.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    @Autowired
    VisitRepo visitRepo;
    public VisitDTO getVisit(Long visit_id) {
        return visitRepo.findVisitByVisitId(visit_id);
    }
}
