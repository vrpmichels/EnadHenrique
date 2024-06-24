package com.exemplo.veiculos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VeiculoServiceTest {
    private VeiculoService veiculoService;

    @BeforeEach
    public void setUp() throws IOException {
        veiculoService = new VeiculoService("veiculos.json");
    }

    @Test
    public void testFiltrarPorMarca() {
        List<Veiculo> resultado = veiculoService.filtrarPorMarca("Toyota");
        assertEquals(2, resultado.size());
        assertEquals("Toyota", resultado.get(0).getMarca());
        assertEquals("Toyota", resultado.get(1).getMarca());
    }

    @Test
    public void testSomarValorPorMarca() {
        int resultado = veiculoService.somarValorPorMarca("Toyota");
        assertEquals(110000, resultado);
    }

    @Test
    public void testFiltrarPorAno() {
        List<Veiculo> resultado = veiculoService.filtrarPorAno(2018);
        assertEquals(3, resultado.size());
        assertEquals(2020, resultado.get(0).getAno());
        assertEquals(2019, resultado.get(1).getAno());
    }
}
