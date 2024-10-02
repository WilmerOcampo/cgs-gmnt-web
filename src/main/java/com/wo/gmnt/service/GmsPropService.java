package com.wo.gmnt.service;

import com.wo.gmnt.model.GmsProp;

import java.util.List;

public interface GmsPropService {
    List<GmsProp> findAll();

    // Método para obtener un propietario por ID
    GmsProp findById(String id);

    // Método para guardar o actualizar un propietario
    GmsProp save(GmsProp propietario);

    // Método para eliminar un propietario por ID
    void delete(String id);


}
