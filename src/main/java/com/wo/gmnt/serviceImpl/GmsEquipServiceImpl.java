package com.wo.gmnt.serviceImpl;


import org.springframework.stereotype.Service;

@Service
public class GmsEquipServiceImpl {
  /*  @Autowired
    private GmsEquipRepository equipRepository;

    @Autowired
    private GmspropRepository propRepository;

    @Autowired
    private GmsareaRepository areasRepository;

    @Autowired
    private GmshpropRepository hPropRepository;

    @Autowired
    private GmshareaRepository hAreasRepository;
    @Override
    public GmsEquip createEquipment(GmsEquip equip) {
        return equipRepository.save(equip);
    }

    @Override
    public GmsEquip updateEquipment(String id, GmsEquip equip) {
        Optional<GmsEquip> existingEquip = equipRepository.findById(id);
        if (existingEquip.isPresent()) {
            GmsEquip updatedEquip = existingEquip.get();
            updatedEquip.setNomeqp(equip.getNomeqp());
            updatedEquip.setModeqp(equip.getModeqp());
            updatedEquip.setIdPro(equip.getIdPro());
            updatedEquip.setIdAre(equip.getIdAre());
            return equipRepository.save(updatedEquip);
        }
        return null;
    }

    @Override
    public GmsEquip getEquipmentById(String id) {
        return equipRepository.findById(id).orElse(null);
    }

    @Override
    public List<GmsEquip> getAllEquipment() {
        return equipRepository.findAll();
    }

    @Override
    public void deleteEquipmentById(String id) {
        equipRepository.deleteById(id);

    }

    @Override
    public List<Gmsprop> getAllOwners() {
        return propRepository.findAll();
    }

    @Override
    public List<Gmsarea> getAllAreas() {
        return areasRepository.findAll();
    }

    @Override
    public void assignOwnerToEquipment(String equipmentId, String ownerId) {
        Optional<GmsEquip> equip = equipRepository.findById(equipmentId);
        Optional<Gmsprop> owner = propRepository.findById(ownerId);

        if (equip.isPresent() && owner.isPresent()) {
            GmsEquip existingEquip = equip.get();
            existingEquip.setIdPro(ownerId);  // Asignar propietario
            equipRepository.save(existingEquip);

            // Guardar en historial
            GmsHprop hProp = new GmsHprop();
            hProp.setIdPro(ownerId);
            hProp.setIdEqp(equipmentId);

            hPropRepository.save(hProp);  // Actualizar historial
        }
    }

    @Override
    public void assignAreaToEquipment(String equipmentId, String areaId) {
        Optional<GmsEquip> equip = equipRepository.findById(equipmentId);
        Optional<Gmsarea> area = areasRepository.findById(areaId);

        if (equip.isPresent() && area.isPresent()) {
            GmsEquip existingEquip = equip.get();
            existingEquip.setIdAre(areaId);  // Asignar área
            equipRepository.save(existingEquip);

            // Guardar en historial
            GmsHareas hArea = new GmsHareas();
            hArea.setIdAre(areaId);
            hArea.setIdEqp(equipmentId);
            hAreasRepository.save(hArea);  // Actualizar historial
        }
    }

    @Override
    public List<Gmsprop> getEquipmentOwnerHistory(String equipmentId) {

        return hPropRepository.findAllByIdEqp(equipmentId);
    }

    @Override
    public List<Gmsarea> getEquipmentAreaHistory(String equipmentId) {
        return hAreasRepository.findAllByIdEqp(equipmentId);
    }

   */
}
