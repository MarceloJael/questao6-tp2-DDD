package com.tp2.petfriends.controller;

import com.tp2.petfriends.model.Cliente;
import com.tp2.petfriends.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/{clienteId}/pets/{petId}")
    public ResponseEntity<Cliente> adicionarPet(@PathVariable Long clienteId, @PathVariable Long petId) {
        Cliente cliente = clienteService.adicionarPet(clienteId, petId);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/{clienteId}/adotar/{petId}")
    public ResponseEntity<Cliente> adotarPet(@PathVariable Long clienteId, @PathVariable Long petId) {
        Cliente cliente = clienteService.adotarPet(clienteId, petId);
        return ResponseEntity.ok(cliente);
    }

}
