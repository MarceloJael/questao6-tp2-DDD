package com.tp2.petfriends.event;

import com.tp2.petfriends.service.ClienteService;
import lombok.Getter;

@Getter
public class PetAdotadoEvent extends DomainEvent {

    private final Long clienteId;
    private final Long petId;

    public PetAdotadoEvent(ClienteService clienteService, Long clienteId, Long petId) {
        super();
        this.clienteId = clienteId;
        this.petId = petId;
    }

    @Override
    public String getEventType() {
        return "PetAdotadoEvent";
    }

    @Override
    public String toString() {
        return "PetAdotadoEvent{" +
                "eventId=" + getEventId() +
                ", occurredOn=" + getOccurredOn() +
                ", clienteId=" + clienteId +
                ", petId=" + petId +
                '}';
    }

}