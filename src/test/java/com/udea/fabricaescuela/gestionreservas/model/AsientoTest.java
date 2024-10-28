package com.udea.fabricaescuela.gestionreservas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Asiento.class, Vuelo.class})
public class AsientoTest {
    @Test
    public void testGettersAndSetters() {
        Asiento asiento = new Asiento();
        Vuelo vuelo = new Vuelo();

        asiento.setIdAsiento(1L);
        asiento.setVuelo(vuelo);
        asiento.setNumeroAsiento(12);
        asiento.setClase("Economy");
        asiento.setEstado("Available");
        asiento.setNombrePasajero("John");
        asiento.setApellidoPasajero("Doe");
        asiento.setEquipaje("Hand Luggage");

        assertEquals(1L, asiento.getIdAsiento());
        assertEquals(vuelo, asiento.getVuelo());
        assertEquals(12, asiento.getNumeroAsiento());
        assertEquals("Economy", asiento.getClase());
        assertEquals("Available", asiento.getEstado());
        assertEquals("John", asiento.getNombrePasajero());
        assertEquals("Doe", asiento.getApellidoPasajero());
        assertEquals("Hand Luggage", asiento.getEquipaje());
    }

    @Test
    public void testDefaultValues() {
        Asiento asiento = new Asiento();

        assertNull(asiento.getIdAsiento());
        assertNull(asiento.getVuelo());
        assertEquals(0, asiento.getNumeroAsiento());
        assertNull(asiento.getClase());
        assertNull(asiento.getEstado());
        assertNull(asiento.getNombrePasajero());
        assertNull(asiento.getApellidoPasajero());
        assertNull(asiento.getEquipaje());
    }
}