package com.udea.fabricaescuela.gestionreservas.service;

import com.udea.fabricaescuela.gestionreservas.model.Vuelo;
import com.udea.fabricaescuela.gestionreservas.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    public List<Vuelo> findAll() {
        return vueloRepository.findAllCustom();
    }

    public List<Vuelo> findVuelos(LocalDate startDate, LocalDate endDate, String origen, String destino) {
        return vueloRepository.findFiltrarOrigenDestinoCustom(startDate, endDate, origen, destino);
    }
}
