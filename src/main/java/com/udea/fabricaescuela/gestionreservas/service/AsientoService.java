package com.udea.fabricaescuela.gestionreservas.service;

import com.udea.fabricaescuela.gestionreservas.model.Asiento;
import com.udea.fabricaescuela.gestionreservas.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsientoService {

    @Autowired
    private AsientoRepository asientoRepository;

    // Método para crear un asiento nuevo
    public Asiento crearAsiento(Asiento asiento) {
        return asientoRepository.save(asiento);
    }

    // Método para editar un asiento existente
    public Asiento editarAsiento(Long idAsiento, Asiento asientoDetails) {
        Optional<Asiento> optionalAsiento = asientoRepository.findById(idAsiento);

        if (optionalAsiento.isPresent()) {
            Asiento asientoExistente = optionalAsiento.get();

            // Actualizar los campos
            asientoExistente.setNombrePasajero(asientoDetails.getNombrePasajero());
            asientoExistente.setApellidoPasajero(asientoDetails.getApellidoPasajero());
            asientoExistente.setEquipaje(asientoDetails.getEquipaje());
            asientoExistente.setClase(asientoDetails.getClase());
            asientoExistente.setNumeroAsiento(asientoDetails.getNumeroAsiento());

            // Guardar los cambios
            return asientoRepository.save(asientoExistente);
        } else {
            throw new RuntimeException("Asiento no encontrado con ID: " + idAsiento);
        }
    }
}
