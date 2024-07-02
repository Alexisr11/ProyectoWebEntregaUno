package com.example.mobiliario.web.controller;

import com.example.mobiliario.domain.service.MobiliarioService;
import com.example.mobiliario.percistence.entity.ClientesEntity;
import com.example.mobiliario.percistence.entity.MobiliarioEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mobiliario")
@CrossOrigin(origins = "*")
@Tag(name = "Mobiliario", description = "Api para la gestion de Mobiliario")
public class MobiliarioController {

    @Autowired
    MobiliarioService mobiliarioService;

    @GetMapping("listadoMobiliario")
    @Operation(summary = "Listado de Mobiliarios", description = "Listaod de todos lo Mobiliarios")
    public List<MobiliarioEntity> getAll(){
        return mobiliarioService.getAll();
    }

    @PostMapping("save")
    @Operation(summary = "Crear Mobiliario", description = "Crea un Mobiliario")
    public MobiliarioEntity save(@Valid @RequestBody MobiliarioEntity mobiliarioEntity){
        return mobiliarioService.save(mobiliarioEntity);
    }

    @PutMapping("update/{Id}")
    @Operation(summary = "Actualiza Mobiliario", description = "Actualiza el valor del mobiliario")
    public MobiliarioEntity update(@RequestBody MobiliarioEntity mobiliarioEntity, @PathVariable(name="Id") int Id){
        MobiliarioEntity m = new MobiliarioEntity();
        m = mobiliarioEntity;
        m.setId(Id);
        return mobiliarioService.save(m);
    }

    @DeleteMapping("delete/{Id}")
    @Operation(summary = "Borrar un Mobiliario", description = "Borrra Mobiliario por Id")
    public String delete(@PathVariable(name="Id") int Id){
        return mobiliarioService.delete(Id);
    }

    @GetMapping("/buscarPorId/{id}")
    @Operation(summary = "Buscar por ID un Mobiliario", description = "Buscar un Mobiliario por ID")
    public ResponseEntity<MobiliarioEntity> getMobiliarioById(@PathVariable int id) {
        Optional<MobiliarioEntity> mobiliario = mobiliarioService.getMobiliarioById(id);
        return mobiliario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
