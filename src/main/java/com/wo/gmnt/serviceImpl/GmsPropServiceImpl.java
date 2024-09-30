package com.wo.gmnt.serviceImpl;


import com.wo.gmnt.model.GmsProp;
import com.wo.gmnt.repository.GmsPropRepository;
import com.wo.gmnt.service.GmsPropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GmsPropServiceImpl implements GmsPropService {
    private final GmsPropRepository propRepository;
    private final Util util;

    @Override
    public List<GmsProp> findAll() {
        return propRepository.findAll();
    }

    @Override
    public Optional<GmsProp> findById(String idPro) {
        return propRepository.findById(idPro);
    }

    @Override
    public GmsProp save(GmsProp prop) {
        if (prop.getIdPro() == null) {
            prop.setFchcre(util.getDate());
            prop.setHracre(util.getTime());
        } else {
            prop.setFchmod(util.getDate());
            prop.setHramod(util.getTime());
        }
        String latestId = propRepository.findLatestId();
        String idProp = util.generateId(latestId, "ARE001");
        prop.setIdPro(idProp);
        return propRepository.save(prop);
    }

    @Override
    public void deleteById(String idPro) {
        propRepository.deleteById(idPro);
    }

}
