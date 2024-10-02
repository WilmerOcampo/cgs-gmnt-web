package com.wo.gmnt.service;


import com.wo.gmnt.model.GmsEquip;

import java.util.List;
import java.util.Optional;

public interface GmsEquipService {
    List<GmsEquip> findAll();

    Optional<GmsEquip> findById(String idEqp);

    GmsEquip save(GmsEquip equip);

    void deleteById(String idEqp);
}




