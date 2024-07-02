package com.example.mobiliario.percistence.crud;

import com.example.mobiliario.percistence.entity.MobiliarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobiliarioRepository extends CrudRepository<MobiliarioEntity, Integer> {

}
