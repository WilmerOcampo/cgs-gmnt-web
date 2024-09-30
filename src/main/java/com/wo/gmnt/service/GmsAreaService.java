package com.wo.gmnt.service;

import com.wo.gmnt.model.GmsArea;

import java.util.List;
import java.util.Optional;

public interface GmsAreaService {
    List<GmsArea> findAll();

    Optional<GmsArea> findById(String idAre);

    GmsArea save(GmsArea prop);

    void deleteById(String idAre);
}
