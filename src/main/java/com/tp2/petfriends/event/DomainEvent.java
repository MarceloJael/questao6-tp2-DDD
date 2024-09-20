package com.tp2.petfriends.event;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class DomainEvent {

    private final UUID eventId;
    private final LocalDateTime occurredOn;

    public DomainEvent() {
        this.eventId = UUID.randomUUID();
        this.occurredOn = LocalDateTime.now();
    }

    public UUID getEventId() {
        return eventId;
    }

    public LocalDateTime getOccurredOn() {
        return occurredOn;
    }

    public abstract String getEventType();
}