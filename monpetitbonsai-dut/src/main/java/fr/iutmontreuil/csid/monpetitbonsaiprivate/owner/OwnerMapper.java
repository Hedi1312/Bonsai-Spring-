package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner;



import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class OwnerMapper {

    public static OwnerDTO mapModelToDto(Owner owner) {
        OwnerDTO own=new OwnerDTO();
        own.setId(owner.getId());
        own.setName(owner.getName());
        own.setBonsais(owner.getBonsais());
        return own;
    }

    public static List<OwnerDTO> mapModels(List<Owner> owners) {
        return owners.stream()
                .map(x->mapModelToDto(x))
                .collect(Collectors.toList());
    }

    public static Owner mapDtoToModel(OwnerDTO ownerDTO) {
        Owner own=new Owner(ownerDTO.getId(),ownerDTO.getName());
        own.setBonsais(ownerDTO.getBonsais());
        return own;
    }

    public static List<Owner> mapDtos(List<OwnerDTO> ownerDTOS) {
        List<Owner>liste=new ArrayList<Owner>();
        for (OwnerDTO o: ownerDTOS) {
            liste.add(mapDtoToModel(o));
        }
        return liste;
    }

    public static OwnerEntity mapModelToEntity(Owner owner) {
        OwnerEntity own=new OwnerEntity();
        own.setId(owner.getId());
        own.setName(owner.getName());
        own.setBonsais(BonsaiMapper.mapModelToDtos(owner.getBonsais()));
        return own;
    }

    public static List<OwnerEntity> mapModelToDtos(List<Owner> owners) {
        return owners.stream()
                .map(x->mapModelToEntity(x))
                .collect(Collectors.toList());
    }

    public static Owner mapEntityToModel(OwnerEntity ownerEntity) {
        Owner own=new Owner(ownerEntity.getId(),ownerEntity.getName());
        own.setBonsais(BonsaiMapper.mapEntities(ownerEntity.getBonsais()));
        return own;
    }

    public static List<Owner> mapEntities(List<OwnerEntity> ownerEntities) {
        return ownerEntities.stream()
                .map(x->mapEntityToModel(x))
                .collect(Collectors.toList());
    }

}
