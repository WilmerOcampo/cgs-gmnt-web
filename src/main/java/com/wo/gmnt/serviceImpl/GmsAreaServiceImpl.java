package com.wo.gmnt.serviceImpl;

import com.wo.gmnt.model.GmsArea;
import com.wo.gmnt.repository.GmsAreaRepository;
import com.wo.gmnt.service.GmsAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GmsAreaServiceImpl implements GmsAreaService {
    @Autowired
    private GmsAreaRepository areaRepository;

    @Override
    public List<GmsArea> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public GmsArea findById(String idAre) {
        return areaRepository.findById(idAre).orElse(null);  // Buscar por ID
    }

    @Override
    public GmsArea save(GmsArea gmsArea) {
        return areaRepository.save(gmsArea);  // Guardar el área
    }

    @Override
    public void delete(String id) {
        areaRepository.deleteById(id);
    }
}
