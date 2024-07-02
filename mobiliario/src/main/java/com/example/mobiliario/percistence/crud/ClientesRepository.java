package com.example.mobiliario.percistence.crud;

import com.example.mobiliario.percistence.entity.ClientesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientesRepository extends CrudRepository<ClientesEntity, Integer> {

    List<ClientesEntity> findByNombreContainingIgnoreCase(String nombre);
}
