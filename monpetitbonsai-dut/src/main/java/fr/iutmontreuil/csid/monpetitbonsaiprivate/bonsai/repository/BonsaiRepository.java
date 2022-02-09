package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.repository;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.BonsaiMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.CareEventMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.CareEventDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareEventDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.CareEventEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BonsaiRepository {

    private final BonsaiDao bonsaiDao;
    private final CareEventDao careEventDao;

    public BonsaiRepository(BonsaiDao bonsaiDao, CareEventDao careEventDao) {
        this.bonsaiDao = bonsaiDao;
        this.careEventDao = careEventDao;
    }

    public Optional<Bonsai> findById(UUID uuid) {
        Optional<BonsaiEntity> entity = bonsaiDao.findById(uuid);
        return entity.map(BonsaiMapper::mapEntityToModel);
    }

    public List<Bonsai> findAll() {
        List<BonsaiEntity> entities = bonsaiDao.findAll();
        return BonsaiMapper.mapEntities(entities);
    }

    public  List<Bonsai>findAll(String status) {
        List<BonsaiEntity> entities = bonsaiDao.findAll(status);
        return BonsaiMapper.mapEntities(entities);
    }

    public Bonsai create(Bonsai bonsai) {
        BonsaiEntity bonsaiToCreate = BonsaiMapper.mapModelToEntity(bonsai);
        BonsaiEntity savedBonsai = bonsaiDao.save(bonsaiToCreate);
        return BonsaiMapper.mapEntityToModel(savedBonsai);
    }

    public Bonsai update(Bonsai bonsai){
        BonsaiEntity bonsaiToUpdate = BonsaiMapper.mapModelToEntity(bonsai);
        BonsaiEntity savedBonsai = bonsaiDao.save(bonsaiToUpdate);
        return BonsaiMapper.mapEntityToModel(savedBonsai);
    }


    public void delete(UUID uuid) {
        bonsaiDao.deleteById(uuid);
    }

    public void replaceStatus(Bonsai b){
        BonsaiEntity bonsaiToUpdate = BonsaiMapper.mapModelToEntity(b);
        bonsaiDao.save(bonsaiToUpdate);
    }

    public List<CareEvent> findAllEventById(UUID bonsai_id) {
        List<CareEventEntity> allEvents = careEventDao.findAllEventsById(bonsai_id);
        return CareEventMapper.mapEntities(allEvents);
    }
    public List<CareEvent> findAllEventById(UUID bonsai_id, String type) {
        List<CareEventEntity> allEvents = careEventDao.findAllEventsById(bonsai_id, type);
        return CareEventMapper.mapEntities(allEvents);
    }

    public CareEvent createEvent(CareEvent careEvent) {
        CareEventEntity careEventToCreate = CareEventMapper.mapModelToEntity(careEvent);
        CareEventEntity savedCareEvent = careEventDao.save(careEventToCreate);
        return CareEventMapper.mapEntityToModel(savedCareEvent);
    }

    public void deleteEvent(UUID event_id) {
        careEventDao.deleteById(event_id);
    }

    public Optional<CareEvent> findEventById(UUID event_id) {
        Optional<CareEventEntity> entity = careEventDao.findById(event_id);
        return entity.map(CareEventMapper::mapEntityToModel);
    }
}
