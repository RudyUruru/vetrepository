package com.project.vetrepository.repository;

import com.project.vetrepository.dto.ManipulationDTO;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManipulationRepo extends JpaRepository<ManipulationDTO, Long> {
    @Query("SELECT m FROM ManipulationDTO m WHERE (:name IS NULL OR m.name LIKE :name%)")
    public List<ManipulationDTO> getManipulations(@Nullable @Param("name") String name);
}
