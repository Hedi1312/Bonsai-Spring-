package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.CareEventDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareEventEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CareEventMapper {


    public static CareEventDTO mapModelToDto(CareEvent care_event) {
        CareEventDTO care_eventDTO=new CareEventDTO();
        care_eventDTO.setId(care_event.getId());
        care_eventDTO.setDatetime(care_event.getDatetime());
        care_eventDTO.setEvent_type(care_event.getEvent_type());
        care_eventDTO.setBonsai_id(care_event.getBonsai_id());
        care_eventDTO.setOwner_id(care_event.getOwner_id());
        return care_eventDTO;
    }

    public static List<CareEventDTO> mapModels(List<CareEvent> careEvents) {
        return careEvents.stream()
                .map(x->mapModelToDto(x))
                .collect(Collectors.toList());
    }

    public static CareEvent mapDtoToModel(CareEventDTO careEventDTO) {
        return new CareEvent(careEventDTO.getId(),careEventDTO.getDatetime(),careEventDTO.getEvent_type(),careEventDTO.getBonsai_id(),careEventDTO.getOwner_id());
    }

    public static List<CareEvent> mapDtos(List<CareEventDTO> careEventsDTOS) {
        return careEventsDTOS.stream()
                .map(x->mapDtoToModel(x))
                .collect(Collectors.toList());
    }

    public static CareEventEntity mapModelToEntity(CareEvent careEvent) {
        CareEventEntity careEventEntity=new CareEventEntity();
        careEventEntity.setId(careEvent.getId());
        careEventEntity.setDatetime(careEvent.getDatetime());
        careEventEntity.setEvent_type(careEvent.getEvent_type());

        OwnerEntity oe=new OwnerEntity();
        oe.setId(careEvent.getOwner_id());
        careEventEntity.setOwnerEntity(oe);

        BonsaiEntity be=new BonsaiEntity();
        be.setId(careEvent.getBonsai_id());
        careEventEntity.setBonsaiEntity(be);

        return careEventEntity;
    }

    public static List<CareEventEntity> mapModelToDtos(List<CareEvent> careEvents) {
        return careEvents.stream()
                .map(x->mapModelToEntity(x))
                .collect(Collectors.toList());
    }

    public static CareEvent mapEntityToModel(CareEventEntity careEventEntity) {
        return new CareEvent(careEventEntity.getId(),careEventEntity.getDatetime(),careEventEntity.getEvent_type(),careEventEntity.getBonsai_id().getId(),careEventEntity.getOwner_id().getId());
    }

    public static List<CareEvent> mapEntities(List<CareEventEntity> careEventEntities) {
        return careEventEntities.stream()
                .map(x->mapEntityToModel(x))
                .collect(Collectors.toList());
    }
}
