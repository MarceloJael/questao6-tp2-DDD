package com.tp2.petfriends.service;

import com.tp2.petfriends.event.PetAdotadoEvent;
import com.tp2.petfriends.model.Cliente;
import com.tp2.petfriends.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ApplicationEventPublisher eventPublisher) {
        this.clienteRepository = clienteRepository;
        this.eventPublisher = eventPublisher;
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente adicionarPet(Long clienteId, Long petId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        cliente.adicionarPet(petId);
        return clienteRepository.save(cliente);
    }

    public Cliente adotarPet(Long clienteId, Long petId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        cliente.adicionarPet(petId);
        Cliente clienteAtualizado = clienteRepository.save(cliente);


        PetAdotadoEvent event = new PetAdotadoEvent(this, clienteId, petId);
        eventPublisher.publishEvent(event);

        return clienteAtualizado;
    }
}