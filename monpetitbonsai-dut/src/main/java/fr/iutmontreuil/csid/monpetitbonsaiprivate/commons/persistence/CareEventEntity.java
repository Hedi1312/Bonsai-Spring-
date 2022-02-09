package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Table(name = "care_event")
@Entity

public class CareEventEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")


    private UUID id;
    @Column(name="datetime")
    private LocalDateTime datetime;

    @Enumerated(EnumType.STRING)
    @Column(name="event_type")
    private CareType event_type;

    @JoinColumn(name="bonsai_id")
    @ManyToOne(targetEntity = BonsaiEntity.class)
    private BonsaiEntity bonsai_id;

    @JoinColumn(name="owner_id")
    @ManyToOne(targetEntity = OwnerEntity.class)
    private OwnerEntity owner_id;

    public CareEventEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public BonsaiEntity getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsaiEntity(BonsaiEntity bonsai_id) {
        this.bonsai_id = bonsai_id;
    }

    public OwnerEntity getOwner_id() {
        return owner_id;
    }

    public void setOwnerEntity(OwnerEntity owner_id) {
        this.owner_id = owner_id;
    }
}
