package com.udea.fabricaescuela.gestionreservas.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VueloTest {

    @Test
    public void testGettersAndSetters() {
        Vuelo vuelo = new Vuelo();
        Avion avion = new Avion();
        LocalDate fechaSalida = LocalDate.of(2023, 10, 1);
        LocalTime horaSalida = LocalTime.of(10, 30);
        LocalDate fechaLlegada = LocalDate.of(2023, 10, 1);
        LocalTime horaLlegada = LocalTime.of(12, 30);

        vuelo.setIdVuelo(1L);
        vuelo.setAvion(avion);
        vuelo.setOrigen("Medellin");
        vuelo.setDestino("Bogota");
        vuelo.setFechaSalida(fechaSalida);
        vuelo.setHoraSalida(horaSalida);
        vuelo.setFechaLlegada(fechaLlegada);
        vuelo.setHoraLlegada(horaLlegada);
        vuelo.setEstadoVuelo("En vuelo");
        vuelo.setPrecioBase(200.0);

        assertEquals(1L, vuelo.getIdVuelo());
        assertEquals(avion, vuelo.getAvion());
        assertEquals("Medellin", vuelo.getOrigen());
        assertEquals("Bogota", vuelo.getDestino());
        assertEquals(fechaSalida, vuelo.getFechaSalida());
        assertEquals(horaSalida, vuelo.getHoraSalida());
        assertEquals(fechaLlegada, vuelo.getFechaLlegada());
        assertEquals(horaLlegada, vuelo.getHoraLlegada());
        assertEquals("En vuelo", vuelo.getEstadoVuelo());
        assertEquals(200.0, vuelo.getPrecioBase());
    }

    @Test
    public void testDefaultValues() {
        Vuelo vuelo = new Vuelo();

        assertNull(vuelo.getIdVuelo());
        assertNull(vuelo.getAvion());
        assertNull(vuelo.getOrigen());
        assertNull(vuelo.getDestino());
        assertNull(vuelo.getFechaSalida());
        assertNull(vuelo.getHoraSalida());
        assertNull(vuelo.getFechaLlegada());
        assertNull(vuelo.getHoraLlegada());
        assertNull(vuelo.getEstadoVuelo());
        assertEquals(0.0, vuelo.getPrecioBase());
    }
}


