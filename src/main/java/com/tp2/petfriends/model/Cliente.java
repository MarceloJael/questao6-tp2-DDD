package com.tp2.petfriends.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String nome;
    @Setter
    private String email;

    @ElementCollection
    private List<Long> petIds = new ArrayList<>(); // Referência aos pets pelo ID

    public Cliente() {
    }

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters

    public void adicionarPet(Long petId) {
        if (!petIds.contains(petId)) {
            petIds.add(petId);
        }
    }
}