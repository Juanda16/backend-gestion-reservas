package com.udea.fabricaescuela.gestionreservas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "avion")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvion;

    @Column(nullable = false)
    private String modelo;

    @Column(name = "capacidad_total", nullable = false)
    private int capacidadTotal;

    @Column(name = "capacidad_economica", nullable = false)
    private int capacidadEconomica;

    @Column(name = "capacidad_ejecutiva", nullable = false)
    private int capacidadEjecutiva;

    // Getters y Setters

    public Long getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Long idAvion) {
        this.idAvion = idAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadEconomica() {
        return capacidadEconomica;
    }

    public void setCapacidadEconomica(int capacidadEconomica) {
        this.capacidadEconomica = capacidadEconomica;
    }

    public int getCapacidadEjecutiva() {
        return capacidadEjecutiva;
    }

    public void setCapacidadEjecutiva(int capacidadEjecutiva) {
        this.capacidadEjecutiva = capacidadEjecutiva;
    }
}
