package com.example.springpatrondto.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@Data
@Entity
@Table(name = "moto")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Moto extends Vehiculo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String cilindrada;

    private String tipo;
}
