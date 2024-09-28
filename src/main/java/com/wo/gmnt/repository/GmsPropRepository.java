package com.wo.gmnt.repository;

import com.wo.gmnt.model.GmsProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GmsPropRepository extends JpaRepository<GmsProp, String> {

    @Query("SELECT SUBSTR(TRIM(p.apppro) || ' ' || TRIM(p.apmpro) || ' ' || TRIM(p.nompro), 1, 30) AS sigpro FROM GmsProp p WHERE p.idPro = ?1")
    Optional<String> findSigProById(String idPro);

}
