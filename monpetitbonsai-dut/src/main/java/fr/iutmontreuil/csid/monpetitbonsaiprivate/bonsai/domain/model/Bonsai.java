package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model;

import java.util.Date;
import java.util.UUID;

public class Bonsai {

    private final UUID id;
    private String name;
    private String species;
    private String status;
    private Date acquisition_date;
    private Integer acquisition_age;


    // Add the missing fields

    public Bonsai(UUID id, String name, String species,Date date,int age,String status) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.status=status;
        this.acquisition_age=age;
        this.acquisition_date=date;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setSpecies(String species) {
        this.species = species;
    }
}
