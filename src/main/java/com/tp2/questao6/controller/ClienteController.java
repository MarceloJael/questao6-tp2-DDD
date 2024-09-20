package com.tp2.questao6.controller;

import com.tp2.questao6.model.Cliente;
import com.tp2.questao6.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

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
}
