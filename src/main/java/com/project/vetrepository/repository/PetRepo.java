package com.project.vetrepository.repository;

import com.project.vetrepository.dto.PetDTO;
import com.project.vetrepository.dto.PetLightDTO;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<PetDTO, Long> {

    @Query("SELECT p from PetLightDTO p WHERE p.owner.client_id=:ownerId AND p.breed IS NOT NULL AND (:kindId IS NULL OR p.kind.id=:kindId)")
    List<PetLightDTO> findAllHaveBreed(@Param("ownerId") Long ownerId, @Nullable @Param("kindId") Long kindId);

    @Query("SELECT p FROM PetLightDTO p WHERE p.owner.client_id=:ownerId" +
            " AND (:kind IS NULL OR p.kind.id=:kind)" +
            " AND (:breed IS NULL OR p.breed.id=:breed)" +
            " AND (:name IS NULL OR p.name LIKE :name%)" +
            " ORDER BY p.name LIMIT :maxCount")
    List<PetLightDTO> findPetsFullFiltered(@Param("ownerId") Long ownerId,
                                               @Nullable @Param("kind") Long kind,
                                               @Nullable @Param("breed") Long breed,
                                               @Nullable @Param("name") String name,
                                               @Param("maxCount") Integer maxCount);

    @Query ("SELECT p FROM PetDTO p WHERE p.pet_id=:id")
    PetDTO findPetById(@Param("id") Long id);

    @Query ("SELECT p FROM PetLightDTO p WHERE p.pet_id=:id")
    PetLightDTO findSimpleById(@Param("id") Long id);
}
