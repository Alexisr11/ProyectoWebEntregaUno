package com.example.mobiliario.web.controller;

import com.example.mobiliario.domain.service.ClienteService;
import com.example.mobiliario.percistence.entity.ClientesEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
@Tag(name = "Clientes", description = "Api para la gestion de Clientes")
public class ClientesController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("listadoClientes")
    @Operation(summary = "Listado de Clientes", description = "Listado de todos lo Clientes")
    public List<ClientesEntity> getAll(){
        return clienteService.getAll();
    }

    @PostMapping("save")
    @Operation(summary = "Crear Cliente", description = "Crea un Cliente")
    public ClientesEntity save(@Valid @RequestBody ClientesEntity clientesEntity){
        return clienteService.save(clientesEntity);
    }

    @PutMapping("update/{Id}")
    @Operation(summary = "Actualiza Cliente", description = "Actualiza el valor del Cliente")
    public ClientesEntity update(@RequestBody ClientesEntity clientesEntity, @PathVariable(name="Id") int Id){
        ClientesEntity c = new ClientesEntity();
        c = clientesEntity;
        c.setId(Id);
        return clienteService.save(c);
    }

    @DeleteMapping("delete/{Id}")
    @Operation(summary = "Borrar un Cliente", description = "Borrra Cliente por Id")
    public String delete(@PathVariable(name="Id") int Id){
        return clienteService.delete(Id);
    }

    @GetMapping("buscarPorId/{Id}")
    @Operation(summary = "Buscar por Id", description = "Buscar Cliente por Id")
    public ResponseEntity<ClientesEntity> getClienteById(@PathVariable(name = "Id") int Id) {
        Optional<ClientesEntity> cliente = clienteService.getClienteById(Id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("buscarPorNombre")
    public ResponseEntity<List<ClientesEntity>> getClientesByNombre(@RequestParam(name = "nombre") String nombre) {
        List<ClientesEntity> clientes = clienteService.getClienteByNombre(nombre);
        return ResponseEntity.ok(clientes);
    }
}
