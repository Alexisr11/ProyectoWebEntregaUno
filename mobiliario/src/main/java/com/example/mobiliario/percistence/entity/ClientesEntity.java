package com.example.mobiliario.percistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="clientes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int Id;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[0-9]+$", message = "El Nit debe contener solo Numeros")
    private String nit;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre debe contener solo letras")
    @Column(name = "nombre")
    private String nombre;
    @NotNull
    @NotEmpty
    private String dereccion;
    private int telefono;

}
