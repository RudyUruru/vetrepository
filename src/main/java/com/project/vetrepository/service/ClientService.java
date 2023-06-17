package com.project.vetrepository.service;


import com.project.vetrepository.dto.ClientLightDTO;
import com.project.vetrepository.dto.VisitDTO;
import com.project.vetrepository.repository.ClientRepo;
import com.project.vetrepository.repository.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    VisitRepo visitRepo;

    public ClientLightDTO getClientInfo(Long id) {
        return clientRepo.findByClientId(id);
    }

    public List<VisitDTO> getVisits(Long id, Long petId, Long kind_id, Long breed_id, LocalDateTime date1, LocalDateTime date2, Integer maxCount) {
        List<VisitDTO> list;
        if (maxCount == null)
            maxCount = Integer.MAX_VALUE;


        list = visitRepo.findVisitsFiltered(id, petId, kind_id, breed_id, date1, date2, maxCount);
        return list;
    }
}
