package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// TODO: complete all the methods !
public class BonsaiMapper {

    public static BonsaiDTO mapModelToDto(Bonsai bonsai) {
        BonsaiDTO bo=new BonsaiDTO();
        bo.setId(bonsai.getId());
        bo.setName(bonsai.getName());
        bo.setSpecies(bonsai.getSpecies());
        bo.setAcquisition_age(bonsai.getAcquisition_age());
        bo.setAcquisition_date(bonsai.getAcquisition_date());
        bo.setStatus(bonsai.getStatus());
        return bo;
    }

    public static List<BonsaiDTO> mapModels(List<Bonsai> bonsais) {
        return bonsais.stream()
                .map(x->mapModelToDto(x))
                .collect(Collectors.toList());
    }

    public static Bonsai mapDtoToModel(BonsaiDTO bonsaiDTO) {
        return new Bonsai(bonsaiDTO.getId(), bonsaiDTO.getName(), bonsaiDTO.getSpecies(),bonsaiDTO.getAcquisition_date(),bonsaiDTO.getAcquisition_age(), bonsaiDTO.getStatus());
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
       be.setAcquisition_date(bonsai.getAcquisition_date());
       be.setStatus(bonsai.getStatus());
       return be;
    }

    public static List<BonsaiEntity> mapModelToDtos(List<Bonsai> bonsais) {
        return bonsais.stream()
                .map(x->mapModelToEntity(x))
                .collect(Collectors.toList());
    }

    public static Bonsai mapEntityToModel(BonsaiEntity bonsaiEntity) {
        return new Bonsai(bonsaiEntity.getId(), bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getAcquisition_date(),bonsaiEntity.getAcquisition_age(), bonsaiEntity.getStatus());
    }

    public static List<Bonsai> mapEntities(List<BonsaiEntity> bonsaiEntities) {
        return bonsaiEntities.stream()
                .map(x->mapEntityToModel(x))
                .collect(Collectors.toList());
    }
}
