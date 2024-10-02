package com.wo.gmnt.repository;

import com.wo.gmnt.model.GmsEquip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GmsEquipRepository extends JpaRepository<GmsEquip, String> {


}
