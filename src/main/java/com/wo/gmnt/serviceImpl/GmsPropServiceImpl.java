package com.wo.gmnt.serviceImpl;

import com.wo.gmnt.model.GmsProp;
import com.wo.gmnt.repository.GmsPropRepository;
import com.wo.gmnt.service.GmsPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GmsPropServiceImpl implements GmsPropService {

    @Autowired
    private GmsPropRepository propRepository;

    @Override
    public List<GmsProp> findAll() {

        return propRepository.findAll();
    }

    @Override
    public GmsProp findById(String id) {
        Optional<GmsProp> gmsProp = propRepository.findById(id);
        return gmsProp.orElse(null);
    }

    @Override
    public GmsProp save(GmsProp propietario) {
        // Obtener el último codpro generado
        String lastCodpro = propRepository.findLastCodpro();

        // Generar el siguiente codpro
        String newCodpro = generateNextCodpro(lastCodpro);

        // Asignar el nuevo codpro al propietario
        propietario.setCodpro(newCodpro);

        // Guardar el propietario
        return propRepository.save(propietario);
    }

    @Override
    public void delete(String id) {
        propRepository.deleteById(id);
    }
    private String generateNextCodpro(String lastCodpro) {
        if (lastCodpro == null || lastCodpro.isEmpty()) {
            return "P001"; // Si no hay registros previos, comenzamos desde P001
        }

        // Extraer el número actual después de "P"
        int currentNumber = Integer.parseInt(lastCodpro.substring(1));

        // Incrementar el número
        int nextNumber = currentNumber + 1;

        // Formatear el nuevo código como "P###"
        return String.format("P%03d", nextNumber);
    }
}
