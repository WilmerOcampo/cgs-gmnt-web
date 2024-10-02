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
        return gmsEquipRepository.save(equip);
    }

    @Override
    public void deleteById(String idEqp) {
        gmsEquipRepository.deleteById(idEqp);
    }




}