package com.udea.fabricaescuela.gestionreservas.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Pago.class})
public class PagoTest {

@Test
public void testGettersAndSetters() {
Pago pago = new Pago();

Long idPago = 1L;
double monto = 100.0;
LocalDateTime fechaPago = LocalDateTime.of(2023, 1, 1, 12, 0);
String metodoPago = "Tarjeta";

pago.setIdPago(idPago);
pago.setMonto(monto);
pago.setFechaPago(fechaPago);
pago.setMetodoPago(metodoPago);

assertEquals(idPago, pago.getIdPago());
assertEquals(monto, pago.getMonto());
assertEquals(fechaPago, pago.getFechaPago());
assertEquals(metodoPago, pago.getMetodoPago());
}

@Test
public void testDefaultFechaPago() {
Pago pago = new Pago();
assertNotNull(pago.getFechaPago());
}
}