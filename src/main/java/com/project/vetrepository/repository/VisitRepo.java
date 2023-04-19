package com.project.vetrepository.repository;

import com.project.vetrepository.dto.VisitDTO;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitRepo extends PagingAndSortingRepository<VisitDTO, Long> {

    @Query("SELECT v FROM VisitDTO v WHERE v.client.client_id=:clientId" +
            " AND (:kind IS NULL OR v.pet.kind.id=:kind)" +
            " AND (:breed IS NULL OR v.pet.breed.id=:breed)" +
            " AND (:date1 IS NULL OR v.date>=:date1)" +
            " AND (:date2 IS NULL OR v.date<=:date2)" +
            " ORDER BY v.date desc")
    List<VisitDTO> findVisitsWithBreed(@Param("clientId") Long clientId,
                              @Nullable @Param("kind") Long kind,
                              @Nullable @Param("breed") Long breed,
                              @Nullable @Param("date1") LocalDateTime date1,
                              @Nullable @Param("date2") LocalDateTime date2);
    @Query("SELECT v FROM VisitDTO v WHERE v.client.client_id=:clientId" +
            " AND (:kind IS NULL OR v.pet.kind.id=:kind)" +
            " AND (:date1 IS NULL OR v.date>=:date1)" +
            " AND (:date2 IS NULL OR v.date<=:date2)" +
            " ORDER BY v.date desc")
    List<VisitDTO> findVisitsByClientId(@Param("clientId") Long clientId,
                                        @Nullable @Param("kind") Long kind,
                                        @Nullable @Param("date1") LocalDateTime date1,
                                        @Nullable @Param("date2") LocalDateTime date2);


    @Query("SELECT v FROM VisitDTO v WHERE v.client.client_id=:clientId" +
            " AND (:kind IS NULL OR v.pet.kind.id=:kind)" +
            " AND (:breed IS NULL OR v.pet.breed.id=:breed)" +
            " AND (:date1 IS NULL OR v.date>=:date1)" +
            " AND (:date2 IS NULL OR v.date<=:date2)" +
            " ORDER BY v.date desc LIMIT :maxCount")
    List<VisitDTO> findVisitsLimitedWithBreed(@Param("clientId") Long clientId,
                                              @Nullable @Param("kind") Long kind,
                                              @Nullable @Param("breed") Long breed,
                                              @Nullable @Param("date1") LocalDateTime date1,
                                              @Nullable @Param("date2") LocalDateTime date2,
                                              @Param("maxCount") Integer maxCount);

    @Query("SELECT v FROM VisitDTO v WHERE v.client.client_id=:clientId" +
            " AND (:kind IS NULL OR v.pet.kind.id=:kind)" +
            " AND (:date1 IS NULL OR v.date>=:date1)" +
            " AND (:date2 IS NULL OR v.date<=:date2)" +
            " ORDER BY v.date desc LIMIT :maxCount")
    List<VisitDTO> findVisitsLimited(@Param("clientId") Long clientId,
                                              @Nullable @Param("kind") Long kind,
                                              @Nullable @Param("date1") LocalDateTime date1,
                                              @Nullable @Param("date2") LocalDateTime date2,
                                              @Param("maxCount") Integer maxCount);

    @Query("SELECT v FROM VisitDTO v WHERE v.visit_id=:visit_id")
    VisitDTO findVisitByVisitId(@Param("visit_id") Long visit_id);
}

