package com.example.springpatrondto.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MotoDto {
    private String marca;
    private String modelo;
    private String color;
    private String cilindrada;
    private String tipo;
    private String placa;

    public MotoDto(String marca, String modelo, String color, String cilindrada, String tipo, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cilindrada = cilindrada;
        this.tipo = tipo;
        this.placa = placa;
    }
}
