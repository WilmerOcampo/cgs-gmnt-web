package com.wo.gmnt.serviceImpl;


import com.wo.gmnt.model.GmsEquip;
import com.wo.gmnt.repository.GmsEquipRepository;
import com.wo.gmnt.service.GmsEquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GmsEquipServiceImpl implements GmsEquipService {
    private final GmsEquipRepository gmsEquipRepository;

    @Override
    public List<GmsEquip> findAll() {
        return gmsEquipRepository.findAll();
    }

    @Override
    public Optional<GmsEquip> findById(String idEqp) {
        return gmsEquipRepository.findById(idEqp);
    }

    @Override
    public GmsEquip save(GmsEquip equip) {
        if (equip.getIdEqp() == null) {
            equip.setFchcre(getDate());
            equip.setHracre(getTime());
        } else {
            equip.setFchmod(getDate());
            equip.setHramod(getTime());
        }
        String latestId = gmsEquipRepository.findLatestId();
        String idEqp = generateIdEqp(latestId);
        equip.setIdEqp(idEqp);
        return gmsEquipRepository.save(equip);
    }

    @Override
    public void deleteById(String idEqp) {
        gmsEquipRepository.deleteById(idEqp);
    }
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
  private String generateIdEqp(String latestId) {
      if (latestId == null) {
          return "EQP001";
      }
      int c = Integer.parseInt(latestId.substring(3));
      c++;
      return String.format("EQP%03d", c);
  }

  private String getDate() {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      return dateFormat.format(new Date());
  }

    private String getTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(new Date());
    }
}
