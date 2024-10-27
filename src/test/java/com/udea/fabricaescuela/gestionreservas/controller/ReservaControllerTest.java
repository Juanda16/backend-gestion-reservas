package com.udea.fabricaescuela.gestionreservas.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.udea.fabricaescuela.gestionreservas.model.Asiento;
import com.udea.fabricaescuela.gestionreservas.model.Pago;
import com.udea.fabricaescuela.gestionreservas.model.Reserva;
import com.udea.fabricaescuela.gestionreservas.service.ReservaService;

@AutoConfigureMockMvc
@SpringBootTest
// @ContextConfiguration(classes = { Asiento.class, Pago.class, Reserva.class })
public class ReservaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservaService reservaService;

    @Test
    public void testGetReservasByIdCliente() throws Exception {
        Long idCliente = 1L;
        Reserva reserva1 = new Reserva();
        reserva1.setIdReserva(1L);
        Reserva reserva2 = new Reserva();
        reserva2.setIdReserva(2L);
        List<Reserva> reservas = Arrays.asList(reserva1, reserva2);

        Mockito.when(reservaService.obtenerReservasPorIdCliente(idCliente)).thenReturn(reservas);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservas/findByIdCliente/{idCliente}", idCliente)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'idReserva': 1}, {'idReserva': 2}]"));
    }

    @Test
    public void testGetReservaById() throws Exception {
        Long id = 1L;
        Reserva reserva = new Reserva();
        reserva.setIdReserva(id);

        Mockito.when(reservaService.obtenerReservaPorId(id)).thenReturn(Optional.of(reserva));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservas/findById/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'idReserva': 1}"));
    }

    @Test
    public void testGetReservaByIdNotFound() throws Exception {
        Long id = 1L;

        Mockito.when(reservaService.obtenerReservaPorId(id)).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservas/findById/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Reserva no encontrada"));
    }

    @Test
    public void testGetAllReservas() throws Exception {
        Reserva reserva1 = new Reserva();
        reserva1.setIdReserva(1L);
        Reserva reserva2 = new Reserva();
        reserva2.setIdReserva(2L);
        List<Reserva> reservas = Arrays.asList(reserva1, reserva2);

        Mockito.when(reservaService.obtenerTodasReservas()).thenReturn(reservas);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservas/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'idReserva': 1}, {'idReserva': 2}]"));
    }

    @Test
    public void testCrearReserva() throws Exception {
        Pago pago = new Pago();
        Asiento asiento1 = new Asiento();
        Asiento asiento2 = new Asiento();
        List<Asiento> asientos = Arrays.asList(asiento1, asiento2);
        Reserva reserva = new Reserva();
        reserva.setIdReserva(1L);

        ReservaController.ReservaReservaRequest request = new ReservaController.ReservaReservaRequest();
        request.setPago(pago);
        request.setAsientos(asientos);
        request.setReserva(reserva);

        Mockito.when(reservaService.crearPagoYReserva(pago, asientos, reserva)).thenReturn(1L);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/reservas/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"pago\":{}, \"asientos\":[{}, {}], \"reserva\":{\"idReserva\":1}}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("0"));
    }
}