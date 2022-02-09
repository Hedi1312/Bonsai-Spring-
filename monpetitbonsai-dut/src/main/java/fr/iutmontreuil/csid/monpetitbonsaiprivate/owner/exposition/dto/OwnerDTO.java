package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OwnerDTO {

    private UUID id;
    private String name;
    private List<Bonsai> bonsais;

    public OwnerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bonsai> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<Bonsai> bonsais) {
        this.bonsais = bonsais;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
