package com.project.vetrepository.repository;

import com.project.vetrepository.dto.ConfigurationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends JpaRepository<ConfigurationDTO, String> {
}
