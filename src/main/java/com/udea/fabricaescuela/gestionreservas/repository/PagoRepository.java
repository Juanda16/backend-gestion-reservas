package com.udea.fabricaescuela.gestionreservas.repository;

import com.udea.fabricaescuela.gestionreservas.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}
