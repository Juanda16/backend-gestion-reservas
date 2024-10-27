package com.udea.fabricaescuela.gestionreservas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Asiento.class, Vuelo.class})
public class AvionTest {

    @Test
    public void testGettersAndSetters() {
        Avion avion = new Avion();
        
        avion.setIdAvion(1L);
        avion.setModelo("Boeing 737");
        avion.setCapacidadTotal(200);
        avion.setCapacidadEconomica(150);
        avion.setCapacidadEjecutiva(50);

        assertEquals(1L, avion.getIdAvion());
        assertEquals("Boeing 737", avion.getModelo());
        assertEquals(200, avion.getCapacidadTotal());
        assertEquals(150, avion.getCapacidadEconomica());
        assertEquals(50, avion.getCapacidadEjecutiva());
    }

    @Test
    public void testDefaultValues() {
        Avion avion = new Avion();

        assertNull(avion.getIdAvion());
        assertNull(avion.getModelo());
        assertEquals(0, avion.getCapacidadTotal());
        assertEquals(0, avion.getCapacidadEconomica());
        assertEquals(0, avion.getCapacidadEjecutiva());
    }
}