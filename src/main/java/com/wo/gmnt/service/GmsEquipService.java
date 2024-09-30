package com.wo.gmnt.service;

import com.wo.gmnt.model.GmsEquip;

import java.util.List;
import java.util.Optional;

public interface GmsEquipService {
    List<GmsEquip> findAll();

    Optional<GmsEquip> findById(String idEqp);

    GmsEquip save(GmsEquip equip);

    void deleteById(String idEqp);
/*
    GmsEquip createEquipment(GmsEquip equip);

    GmsEquip updateEquipment(String id, GmsEquip equip);

    GmsEquip getEquipmentById(String id);

    List<GmsEquip> getAllEquipment();

    void deleteEquipmentById(String id);

    // Para los dropdowns
    List<Gmsprop> getAllOwners();

    List<Gmsarea> getAllAreas();

    // Asignación de propietarios y áreas
    void assignOwnerToEquipment(String equipmentId, String ownerId);

    void assignAreaToEquipment(String equipmentId, String areaId);

    // Obtener el historial
    List<Gmsprop> getEquipmentOwnerHistory(String equipmentId);

    List<Gmsarea> getEquipmentAreaHistory(String equipmentId);

 */
}
