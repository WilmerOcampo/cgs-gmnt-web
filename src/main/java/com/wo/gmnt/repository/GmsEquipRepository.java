package com.wo.gmnt.repository;

import com.wo.gmnt.model.GmsEquip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GmsEquipRepository extends JpaRepository<GmsEquip, String> {

    @Query("SELECT MAX(e.idEqp) FROM GmsEquip e")
    String findLatestId();

}
