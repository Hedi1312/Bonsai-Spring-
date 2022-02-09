package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "Bonsai")
@Table(name = "bonsai")
public class BonsaiEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name="name")
    private String name;
    @Column(name="species")
    private String species;
    @Column(name="status")
    private String status;
    @Column(name="acquisition_date")
    private Date acquisition_date;
    @Column(name="acquisition_age")
    private int acquisition_age;

    @JoinColumn(name="owner_id")

    @ManyToOne(targetEntity = OwnerEntity.class)
    private OwnerEntity ownerEntity;


    public BonsaiEntity() {
    }

    public String getName() {return this.name;}
    public void setName(String newname){this.name=newname;}

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(Date acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }
}
