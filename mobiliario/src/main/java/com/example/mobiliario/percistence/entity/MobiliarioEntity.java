package com.example.mobiliario.percistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="mobiliario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MobiliarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mobiliario")
    private int Id;
    @NotNull(message = "El campo codigo no puede ser nulo")
    @NotEmpty
    private String codigo;
    @NotEmpty
    @NotNull(message = "El campo Descripcion no puede ser nulo")
    private String descripcion;
}
