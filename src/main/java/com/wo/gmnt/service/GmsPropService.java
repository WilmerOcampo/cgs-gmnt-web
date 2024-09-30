package com.wo.gmnt.service;

import com.wo.gmnt.model.GmsProp;

import java.util.List;
import java.util.Optional;

public interface GmsPropService {
    List<GmsProp> findAll();

    Optional<GmsProp> findById(String idPro);

    GmsProp save(GmsProp prop);

    void deleteById(String idPro);
}
