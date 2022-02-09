package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto;

import java.util.UUID;

public class BonsaiDTO {

    private UUID id;
    private String name;
    private String species;
    private Integer acquisition_age;
    private UUID ownerId;


    public BonsaiDTO() {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(Integer acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }
}
