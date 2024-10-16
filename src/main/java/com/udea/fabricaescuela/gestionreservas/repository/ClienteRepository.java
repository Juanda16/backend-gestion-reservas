package com.udea.fabricaescuela.gestionreservas.repository;

import com.udea.fabricaescuela.gestionreservas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
