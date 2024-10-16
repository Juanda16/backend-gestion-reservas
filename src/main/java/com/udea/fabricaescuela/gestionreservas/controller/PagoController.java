package com.udea.fabricaescuela.gestionreservas.controller;

import com.udea.fabricaescuela.gestionreservas.model.Pago;
import com.udea.fabricaescuela.gestionreservas.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping("/crear")
    public Pago crearPago(@RequestBody Pago pago) {
        return pagoService.crearPago(pago);
    }
}
