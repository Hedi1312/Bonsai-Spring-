package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

// TODO: complete all the methods !
public class BonsaiMapper {

    public static BonsaiDTO mapModelToDto(Bonsai bonsai) {
        BonsaiDTO bo=new BonsaiDTO();
        bo.setId(bonsai.getId());
        bo.setName(bonsai.getName());
        bo.setSpecies(bonsai.getSpecies());
        bo.setAcquisition_age(bonsai.getAcquisition_age());
        bo.setOwnerId(bonsai.getOwnerId());
        return bo;
    }

    public static List<BonsaiDTO> mapModels(List<Bonsai> bonsais) {
        return bonsais.stream()
                .map(x->mapModelToDto(x))
                .collect(Collectors.toList());
    }

    public static Bonsai mapDtoToModel(BonsaiDTO bonsaiDTO) {
        return new Bonsai(bonsaiDTO.getId(),bonsaiDTO.getName(), bonsaiDTO.getSpecies(), bonsaiDTO.getAcquisition_age(), bonsaiDTO.getOwnerId());
    }

    public static List<Bonsai> mapDtos(List<BonsaiDTO> bonsaiDTOS) {
        return bonsaiDTOS.stream()
                .map(x->mapDtoToModel(x))
                .collect(Collectors.toList());
    }

    public static BonsaiEntity mapModelToEntity(Bonsai bonsai) {
       BonsaiEntity be=new BonsaiEntity();
       be.setId(bonsai.getId());
       be.setName(bonsai.getName());
       be.setSpecies(bonsai.getSpecies());
       be.setAcquisition_age(bonsai.getAcquisition_age());
       OwnerEntity o=new OwnerEntity();
       o.setId(bonsai.getOwnerId());
       be.setOwnerEntity(o);
       return be;
    }

    public static List<BonsaiEntity> mapModelToDtos(List<Bonsai> bonsais) {
        List<BonsaiEntity> e = new ArrayList<>();
        if(bonsais != null){
            e = bonsais.stream()
                    .map(x->mapModelToEntity(x))
                    .collect(Collectors.toList());
        }
        return e;
    }

    public static Bonsai mapEntityToModel(BonsaiEntity bonsaiEntity) {
        UUID u=null;
        if(bonsaiEntity.getOwnerEntity()!=null) {
            u=bonsaiEntity.getOwnerEntity().getId();
        }
        return new Bonsai(bonsaiEntity.getId(), bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getAcquisition_age(),u);
    }

    public static List<Bonsai> mapEntities(List<BonsaiEntity> bonsaiEntities) {
        return bonsaiEntities.stream()
                .map(x->mapEntityToModel(x))
                .collect(Collectors.toList());
    }
}
