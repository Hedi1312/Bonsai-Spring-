package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "Owner")
@Table(name = "owner")

public class OwnerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")

    private UUID id;
    @Column(name="name")
    private String name;

    @OneToMany(targetEntity = BonsaiEntity.class,mappedBy = "ownerEntity")
    private List<BonsaiEntity>bonsais;

    public OwnerEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<BonsaiEntity> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<BonsaiEntity> bonsais) {
        this.bonsais = bonsais;
    }

    public void setName(String name) {
        this.name = name;
    }
}
