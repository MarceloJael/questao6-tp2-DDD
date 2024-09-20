package com.tp2.petfriends.listener;

import com.tp2.petfriends.event.PetAdotadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PetAdotadoEventListener {

    // Método que reage ao evento 'PetAdotadoEvent'
    @EventListener
    public void onPetAdotado(PetAdotadoEvent event) {
        System.out.println("Evento de domínio recebido:");
        System.out.println("Cliente ID: " + event.getClienteId() + " adotou o Pet ID: " + event.getPetId());
    }

}