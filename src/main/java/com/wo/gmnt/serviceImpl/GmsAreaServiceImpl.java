package com.wo.gmnt.serviceImpl;

import com.wo.gmnt.model.GmsArea;
import com.wo.gmnt.repository.GmsAreaRepository;
import com.wo.gmnt.service.GmsAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GmsAreaServiceImpl implements GmsAreaService {
    private final GmsAreaRepository gmsAreaRepository;
    private final Util util;

    @Override
    public List<GmsArea> findAll() {
        return gmsAreaRepository.findAll();
    }

    @Override
    public Optional<GmsArea> findById(String idAre) {
        return gmsAreaRepository.findById(idAre);
    }

    @Override
    public GmsArea save(GmsArea area) {
        if (area.getIdAre() == null) {
            area.setFchcre(util.getDate());
            area.setHracre(util.getTime());
        } else {
            area.setFchmod(util.getDate());
            area.setHramod(util.getTime());
        }
        String latestId = gmsAreaRepository.findLatestId();
        String idAre = util.generateId(latestId, "ARE001");
        area.setIdAre(idAre);
        return gmsAreaRepository.save(area);
    }

    @Override
    public void deleteById(String idAre) {
        gmsAreaRepository.deleteById(idAre);
    }

}
