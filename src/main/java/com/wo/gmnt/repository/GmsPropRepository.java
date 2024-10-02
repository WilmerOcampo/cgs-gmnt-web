package com.wo.gmnt.repository;

import com.wo.gmnt.model.GmsProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GmsPropRepository extends JpaRepository<GmsProp, String> {

    // Usamos una consulta nativa para obtener el último código generado
    @Query(value = "SELECT codpro FROM gms_prop ORDER BY codpro DESC LIMIT 1", nativeQuery = true)
    String findLastCodpro();


}
