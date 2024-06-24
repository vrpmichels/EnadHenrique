package com.exemplo.veiculos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class VeiculoService {
    private List<Veiculo> veiculos;

    public VeiculoService(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        veiculos = objectMapper.readValue(new File(filePath), new TypeReference<List<Veiculo>>(){});
    }

    public List<Veiculo> filtrarPorMarca(String marca) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    public int somarValorPorMarca(String marca) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getMarca().equalsIgnoreCase(marca))
                .mapToInt(Veiculo::getValor)
                .sum();
    }

    public List<Veiculo> filtrarPorAno(int ano) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getAno() > ano)
                .collect(Collectors.toList());
    }
}
