package com.wo.gmnt.repository;

import com.wo.gmnt.model.GmsArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GmsAreaRepository extends JpaRepository<GmsArea, String> {

    @Query("SELECT MAX(a.idAre) FROM GmsArea a")
    String findLatestId();

}
