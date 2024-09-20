package com.tp2.petfriends.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PetAdotadoEvent extends ApplicationEvent {

    private final Long clienteId;
    private final Long petId;

    public PetAdotadoEvent(Object source, Long clienteId, Long petId) {
        super(source);
        this.clienteId = clienteId;
        this.petId = petId;
    }

}