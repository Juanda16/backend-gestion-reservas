package com.udea.fabricaescuela.gestionreservas.repository;

import com.udea.fabricaescuela.gestionreservas.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    @Query("SELECT v FROM Vuelo v")
    List<Vuelo> findAllCustom();

    @Query("SELECT v FROM Vuelo v WHERE " +
            "(v.fechaSalida >= :startDate) " +
            "AND (v.fechaSalida <= :endDate) "+
            "AND (COALESCE(:origen, '') = '' OR LOWER(v.origen) LIKE CONCAT('%', LOWER(:origen), '%')) " +
            "AND (COALESCE(:destino, '') = '' OR LOWER(v.destino) LIKE CONCAT('%', LOWER(:destino), '%'))")
    List<Vuelo> findFiltrarOrigenDestinoCustom(@Param("startDate") LocalDate startDate,
                                               @Param("endDate") LocalDate endDate,
                                               @Param("origen") String origen,
                                               @Param("destino") String destino);
}
