// package com.udea.fabricaescuela.gestionreservas.model;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
// public class ReservaTest {

//     @Test
//     public void testGettersAndSetters() {
//         Reserva reserva = new Reserva();
//         Cliente cliente = new Cliente();
//         Vuelo vuelo = new Vuelo();
//         Pago pago = new Pago();
//         List<Asiento> asientos = new ArrayList<>();
//         LocalDateTime fechaReserva = LocalDateTime.of(2023, 10, 1, 12, 0);
//         String estadoReserva = "Confirmed";

//         reserva.setIdReserva(1L);
//         reserva.setCliente(cliente);
//         reserva.setVuelo(vuelo);
//         reserva.setPago(pago);
//         reserva.setAsientos(asientos);
//         reserva.setFechaReserva(fechaReserva);
//         reserva.setEstadoReserva(estadoReserva);

//         assertEquals(1L, reserva.getIdReserva());
//         assertEquals(cliente, reserva.getCliente());
//         assertEquals(vuelo, reserva.getVuelo());
//         assertEquals(pago, reserva.getPago());
//         assertEquals(asientos, reserva.getAsientos());
//         assertEquals(fechaReserva, reserva.getFechaReserva());
//         assertEquals(estadoReserva, reserva.getEstadoReserva());
//     }

//     @Test
//     public void testDefaultFechaReserva() {
//         Reserva reserva = new Reserva();
//         assertNotNull(reserva.getFechaReserva());
//     }
// }