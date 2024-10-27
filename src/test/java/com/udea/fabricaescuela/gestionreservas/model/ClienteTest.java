package com.udea.fabricaescuela.gestionreservas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteTest {

    @Test
    public void testGettersAndSetters() {
        Cliente cliente = new Cliente();
        
        cliente.setIdCliente(1L);
        cliente.setNombre("John");
        cliente.setApellido("Doe");
        cliente.setCorreo("john.doe@example.com");
        cliente.setTelefono("1234567890");
        cliente.setFechaNacimiento(LocalDate.of(1990, 1, 1));
        LocalDateTime now = LocalDateTime.now();
        cliente.setFechaRegistro(now);

        assertEquals(1L, cliente.getIdCliente());
        assertEquals("John", cliente.getNombre());
        assertEquals("Doe", cliente.getApellido());
        assertEquals("john.doe@example.com", cliente.getCorreo());
        assertEquals("1234567890", cliente.getTelefono());
        assertEquals(LocalDate.of(1990, 1, 1), cliente.getFechaNacimiento());
        assertEquals(now, cliente.getFechaRegistro());
    }

    @Test
    public void testDefaultFechaRegistro() {
        Cliente cliente = new Cliente();
        assertNotNull(cliente.getFechaRegistro());
    }
}