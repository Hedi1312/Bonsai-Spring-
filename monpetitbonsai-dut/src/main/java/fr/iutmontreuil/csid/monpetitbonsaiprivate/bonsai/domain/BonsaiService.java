package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.repository.BonsaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BonsaiService {

    private final BonsaiRepository bonsaiRepository;

    public BonsaiService(BonsaiRepository bonsaiRepository) {
        this.bonsaiRepository = bonsaiRepository;
    }

    public Optional<Bonsai> findById(UUID uuid) {
        return bonsaiRepository.findById(uuid);
    }

    public List<Bonsai> findAll() {
        return bonsaiRepository.findAll();
    }

    public List<Bonsai>findAll(String status) {
        return bonsaiRepository.findAll(status);
    }

    public Bonsai create(Bonsai bonsai) {
        return bonsaiRepository.create(bonsai);
    }

    public Bonsai update(Bonsai bonsai,UUID uuid) {
        Bonsai bonsai1Founded = this.findById(uuid).get();

        if(bonsai.getName() != null){
            bonsai1Founded.setName(bonsai.getName());
        }
        if(bonsai.getSpecies() != null){
            bonsai1Founded.setSpecies(bonsai.getSpecies());
        }
        return bonsaiRepository.update(bonsai1Founded);
    }


    public void delete(UUID uuid){
        bonsaiRepository.delete(uuid);
    }

    public void replaceStatus(UUID uuid, String s) {
        Bonsai bonsaiFounded = this.findById(uuid).get();
        String status= s.toLowerCase();
        if (status.equals("dead")||status.equals("alive")|| status.equals("unknow")) {
            bonsaiFounded.setStatus(status);
        }
        bonsaiRepository.replaceStatus(bonsaiFounded);
    }


    public List<CareEvent> findAllEventsById(UUID bonsai_id) {
        return bonsaiRepository.findAllEventById(bonsai_id);
    }

    public List<CareEvent> findAllEventsById(UUID bonsai_id, String type) {
        return bonsaiRepository.findAllEventById(bonsai_id, type);
    }


    public CareEvent createEvent(CareEvent careEvent) {
        return bonsaiRepository.createEvent(careEvent);
    }

    public void deleteEvent(UUID event_id, UUID bonsai_id) {
        bonsaiRepository.deleteEvent(event_id);
    }

    public Optional<CareEvent> findEventById(UUID event_id) {
        return bonsaiRepository.findEventById(event_id);
    }
}
