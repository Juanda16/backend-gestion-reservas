package com.udea.fabricaescuela.gestionreservas.controller;

import com.udea.fabricaescuela.gestionreservas.model.Vuelo;
import com.udea.fabricaescuela.gestionreservas.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping("/getAll")
    public List<Vuelo> getAllClientes() {
        return vueloService.findAll();
    }

    @GetMapping("/buscar")
    public List<Vuelo> findVuelos(@RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate,
                                  @RequestParam(value = "origen", required = false) String origen,
                                  @RequestParam(value = "destino", required = false) String destino) {
        return vueloService.findVuelos(LocalDate.parse(startDate),LocalDate.parse(endDate), origen, destino);
    }

    // Otros endpoints
}
