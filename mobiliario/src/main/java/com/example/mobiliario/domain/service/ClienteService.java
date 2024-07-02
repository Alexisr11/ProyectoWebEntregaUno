package com.example.mobiliario.domain.service;

import com.example.mobiliario.percistence.crud.ClientesRepository;
import com.example.mobiliario.percistence.entity.ClientesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClientesRepository clientesRepository;

    public List<ClientesEntity> getAll(){
        return (List<ClientesEntity>) clientesRepository.findAll();
    }

    public ClientesEntity save(ClientesEntity clientesEntity){
        return clientesRepository.save(clientesEntity);
    }

    public String delete(int Id){
        clientesRepository.deleteById(Id);
        return "Cliente eliminado con Exito";
    }

    public Optional<ClientesEntity> getClienteById(int id) {
        return clientesRepository.findById(id);
    }

    public List<ClientesEntity> getClienteByNombre(String nombre){
        return clientesRepository.findByNombreContainingIgnoreCase(nombre);
    }

}
