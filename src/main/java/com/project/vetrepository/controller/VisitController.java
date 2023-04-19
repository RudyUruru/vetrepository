package com.project.vetrepository.controller;

import com.project.vetrepository.UserInfo;
import com.project.vetrepository.dto.VisitDTO;
import com.project.vetrepository.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4")
public class VisitController {
    @Autowired
    VisitService visitService;

    @GetMapping("/visit")
    public ResponseEntity<VisitDTO> getVisit(/*@RequestParam Long visit_id*/) {
        return ResponseEntity.ok(visitService.getVisit(UserInfo.VISIT_ID));
    }
}
