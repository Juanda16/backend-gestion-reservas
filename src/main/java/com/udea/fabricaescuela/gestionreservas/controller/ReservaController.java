package com.udea.fabricaescuela.gestionreservas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.fabricaescuela.gestionreservas.model.Asiento;
import com.udea.fabricaescuela.gestionreservas.model.Pago;
import com.udea.fabricaescuela.gestionreservas.model.Reserva;
import com.udea.fabricaescuela.gestionreservas.service.ReservaService;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> getReservaById(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.obtenerReservaPorId(id);
        if (reserva.isPresent()) {
            return ResponseEntity.ok(reserva.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva no encontrada");
        }
    }

    @GetMapping("/findByIdCliente/{idCliente}")
    public ResponseEntity<List<Reserva>> getReservasByIdCliente(@PathVariable Long idCliente) {
        List<Reserva> reservas = reservaService.obtenerReservasPorIdCliente(idCliente);
        return ResponseEntity.ok(reservas);
    }

    // Nuevo endpoint para listar todas las reservas
    @GetMapping("/")
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reservas = reservaService.obtenerTodasReservas();
        return ResponseEntity.ok(reservas);
    }

    @PostMapping("/crear")
    public ResponseEntity<Long> crearReserva(@RequestBody ReservaReservaRequest request) {
        Pago pago = request.getPago();
        List<Asiento> asientos = request.getAsientos(); // Asegúrate de que esto sea una lista
        Reserva reserva = request.getReserva();

        // Llama al servicio con la lista de asientos
        Long idReservaCreada = reservaService.crearPagoYReserva(pago, asientos, reserva);

        return ResponseEntity.status(HttpStatus.CREATED).body(idReservaCreada);
    }

    public static class ReservaReservaRequest {
        private Pago pago;
        private List<Asiento> asientos; // Cambiado a List<Asiento>
        private Reserva reserva;

        // Getters y Setters
        public Pago getPago() {
            return pago;
        }

        public void setPago(Pago pago) {
            this.pago = pago;
        }

        public List<Asiento> getAsientos() {
            return asientos;
        }

        public void setAsientos(List<Asiento> asientos) {
            this.asientos = asientos;
        }

        public Reserva getReserva() {
            return reserva;
        }

        public void setReserva(Reserva reserva) {
            this.reserva = reserva;
        }
    }
}

//control