package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareType;

import java.time.LocalDateTime;
import java.util.UUID;

public class CareEvent {

    private final UUID id;
    private LocalDateTime datetime;
    private CareType event_type;
    private UUID bonsai_id;
    private UUID owner_id;

    public CareEvent(UUID id, LocalDateTime datetime, CareType event_type, UUID bonsai_id, UUID owner_id) {
        this.id = id;
        this.datetime = datetime;
        this.event_type = event_type;
        this.bonsai_id = bonsai_id;
        this.owner_id = owner_id;
    }

    public UUID getId() {
        return id;
    }


    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public CareType getEvent_type() {
        return event_type;
    }

    public void setEvent_type(CareType event_type) {
        this.event_type = event_type;
    }

    public UUID getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsai_id(UUID bonsai_id) {
        this.bonsai_id = bonsai_id;
    }

    public UUID getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(UUID owner_id) {
        this.owner_id = owner_id;
    }
}
