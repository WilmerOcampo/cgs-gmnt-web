package com.wo.gmnt.service;

import com.wo.gmnt.model.GmsArea;

import java.util.List;

public interface GmsAreaService {

    List<GmsArea> findAll();

    // Método para obtener un área por ID
    GmsArea findById(String idAre);

    // Método para guardar o actualizar un área
    GmsArea save(GmsArea gmsArea);

    // Método para eliminar un área por ID
    void delete(String id);
}
