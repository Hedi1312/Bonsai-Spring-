package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model;

import java.util.UUID;

public class Bonsai {

    private final UUID id;
    private String name;
    private String species;
    private Integer acquisition_age;
    private UUID ownerId;


    public Bonsai(UUID id, String name, String species, Integer age,UUID ownerId) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.acquisition_age = age;
        this.ownerId=ownerId;
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

    public void setAge(Integer age) {
        this.acquisition_age = age;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }
}
