package com.udea.fabricaescuela.gestionreservas.service;

import com.udea.fabricaescuela.gestionreservas.model.Pago;
import com.udea.fabricaescuela.gestionreservas.model.Asiento;
import com.udea.fabricaescuela.gestionreservas.model.Reserva;
import com.udea.fabricaescuela.gestionreservas.repository.ReservaRepository;
import com.udea.fabricaescuela.gestionreservas.repository.PagoRepository;
import com.udea.fabricaescuela.gestionreservas.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    // Método para obtener una reserva por ID
    public Optional<Reserva> obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    // Nuevo método para obtener todas las reservas
    public List<Reserva> obtenerTodasReservas() {
        return reservaRepository.findAll();
    }

    // Nuevo método para obtener reservas por ID de cliente
    public List<Reserva> obtenerReservasPorIdCliente(Long idCliente) {
        return reservaRepository.findByCliente_IdCliente(idCliente);
    }
    @Transactional
    public Long crearPagoYReserva(Pago pago, List<Asiento> asientos, Reserva reserva) {
        // Crear y guardar el pago
        Pago nuevoPago = pagoRepository.save(pago);

        // Guardar la reserva y asignar el objeto de pago
        reserva.setPago(nuevoPago);
        Reserva nuevaReserva = reservaRepository.save(reserva);

        // Asignar la reserva a los asientos y guardar la relación en la tabla intermedia
        for (Asiento asiento : asientos) {
            // Guardar el asiento con la reserva asignada
            asiento.setEstado("reservado"); // Actualizar el estado del asiento
            asiento.setNombrePasajero(reserva.getCliente().getNombre());
            asiento.setApellidoPasajero(reserva.getCliente().getApellido());
            // Se asume que el asiento ya tiene el id_vuelo definido, si no, tendrás que establecerlo
            asientoRepository.save(asiento); // Guardar el asiento actualizado
            nuevaReserva.getAsientos().add(asiento); // Agregar el asiento a la lista de asientos de la reserva
        }

        // Actualizar la reserva con los asientos
        reservaRepository.save(nuevaReserva); // Guardar la reserva con la relación de asientos

        // Devolver el ID de la reserva creada
        return nuevaReserva.getIdReserva();
    }
}

//control