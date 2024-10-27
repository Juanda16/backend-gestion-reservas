package com.udea.fabricaescuela.gestionreservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.fabricaescuela.gestionreservas.model.Asiento;
import com.udea.fabricaescuela.gestionreservas.service.AsientoService;

@RestController
@RequestMapping("/api/asientos")
public class AsientoController {

    @Autowired
    private AsientoService asientoService;

    @PostMapping("/crear")
    public Asiento crearAsiento(@RequestBody Asiento asiento) {
        return asientoService.crearAsiento(asiento);
    }

    // Endpoint para editar un asiento existente
    @PutMapping("/editar/{idAsiento}")
    public ResponseEntity<?> editarAsiento(@PathVariable Long idAsiento, @RequestBody Asiento asientoDetails) {
        try {
            Asiento asientoEditado = asientoService.editarAsiento(idAsiento, asientoDetails);
            return ResponseEntity.ok(asientoEditado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
