package com.example.mobiliario.domain.service;

import com.example.mobiliario.percistence.crud.MobiliarioRepository;
import com.example.mobiliario.percistence.entity.ClientesEntity;
import com.example.mobiliario.percistence.entity.MobiliarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobiliarioService {

    @Autowired
    MobiliarioRepository mobiliarioRepository;

    public List<MobiliarioEntity> getAll(){
        return (List<MobiliarioEntity>) mobiliarioRepository.findAll();
    }

    public MobiliarioEntity save(MobiliarioEntity mobiliarioEntity){
        return mobiliarioRepository.save(mobiliarioEntity);
    }

    public String delete(int Id){
        mobiliarioRepository.deleteById(Id);
        return "Mobiliario eliminado con Exito";
    }

    public Optional<MobiliarioEntity> getMobiliarioById(int id) {
        return mobiliarioRepository.findById(id);
    }
}
