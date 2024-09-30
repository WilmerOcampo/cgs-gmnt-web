package com.wo.gmnt.serviceImpl;


import com.wo.gmnt.model.GmsEquip;
import com.wo.gmnt.repository.GmsEquipRepository;
import com.wo.gmnt.service.GmsEquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GmsEquipServiceImpl implements GmsEquipService {
    private final GmsEquipRepository gmsEquipRepository;
    private final Util util;

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
            equip.setFchcre(util.getDate());
            equip.setHracre(util.getTime());
        } else {
            equip.setFchmod(util.getDate());
            equip.setHramod(util.getTime());
        }
        String latestId = gmsEquipRepository.findLatestId();
        String idEqp = util.generateId(latestId, "EQP001");
        String codeEqp = util.generateCode(latestId, "E001");
        equip.setIdEqp(idEqp);
        equip.setCodeqp(codeEqp);

        // POR EL MOMENTO
        equip.setCodmar("MAR001");

        return gmsEquipRepository.save(equip);
    }

    @Override
    public void deleteById(String idEqp) {
        gmsEquipRepository.deleteById(idEqp);
    }

}
