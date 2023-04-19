package com.project.vetrepository.repository;

import com.project.vetrepository.dto.PetLightDTO;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends PagingAndSortingRepository<PetLightDTO, Long> {

    @Query("SELECT p FROM PetLightDTO p WHERE p.owner.client_id=:ownerId" +
            " AND (:kind IS NULL OR p.kind.id=:kind)" +
            " AND (:breed IS NULL OR p.breed.id=:breed)")
    List<PetLightDTO> findPetsByBreed(@Param("ownerId") Long ownerId,
                                      @Nullable @Param("kind") Long kind,
                                      @Nullable @Param("breed") Long breed);
    @Query("SELECT p FROM PetLightDTO p WHERE p.owner.client_id=:ownerId" +
            " AND (:kind IS NULL OR p.kind.id=:kind)")
    List<PetLightDTO> findPets(@Param("ownerId") Long ownerId,
                                      @Nullable @Param("kind") Long kind);

    @Query("SELECT p FROM PetLightDTO p WHERE p.owner.client_id=:ownerId" +
            " AND (:kind IS NULL OR p.kind.id=:kind)" +
            " AND (:breed IS NULL OR p.breed.id=:breed)" +
            " ORDER BY p.name LIMIT :maxCount")
    List<PetLightDTO> findPetsLimitedWithBreed(@Param("ownerId") Long ownerId,
                                      @Nullable @Param("kind") Long kind,
                                      @Nullable @Param("breed") Long breed,
                                      @Param("maxCount") Integer maxCount);

    @Query("SELECT p FROM PetLightDTO p WHERE p.owner.client_id=:ownerId AND (:kind IS NULL OR p.kind.id=:kind) ORDER BY p.name LIMIT :maxCount")
    List<PetLightDTO> findPetsLimited(@Param("ownerId") Long ownerId,
                                               @Nullable @Param("kind") Long kind,
                                               @Param("maxCount") Integer maxCount);

    @Query("SELECT p from PetLightDTO p WHERE p.owner.client_id=:ownerId AND p.breed IS NOT NULL")
    List<PetLightDTO> findAllHaveBreed(@Param("ownerId") Long ownerId);

}
