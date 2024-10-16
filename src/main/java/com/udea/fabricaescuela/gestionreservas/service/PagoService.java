package com.udea.fabricaescuela.gestionreservas.service;

import com.udea.fabricaescuela.gestionreservas.model.Pago;
import com.udea.fabricaescuela.gestionreservas.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }
}
