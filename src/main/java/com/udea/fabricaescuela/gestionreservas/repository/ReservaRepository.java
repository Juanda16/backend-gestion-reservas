package com.udea.fabricaescuela.gestionreservas.repository;

import com.udea.fabricaescuela.gestionreservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Devuelve un Optional que contiene la reserva si se encuentra, o vacío si no se encuentra
    Optional<Reserva> findById(Long id);

    // Método para encontrar reservas por id_cliente
    List<Reserva> findByCliente_IdCliente(Long idCliente);
}

//control