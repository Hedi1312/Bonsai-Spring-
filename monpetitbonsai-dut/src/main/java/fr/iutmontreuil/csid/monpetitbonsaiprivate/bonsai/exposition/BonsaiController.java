package fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.BonsaiMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.CareEventMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.BonsaiService;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.domain.model.CareEvent;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.bonsai.exposition.dto.CareEventDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {

    private final BonsaiService bonsaiService;

    public BonsaiController(BonsaiService bonsaiService) {
        this.bonsaiService = bonsaiService;
    }

    @GetMapping
    public List<BonsaiDTO> findAllBonsais(@RequestParam(required = false, name = "status") String status) {
        List<Bonsai> bonsais= new ArrayList<Bonsai>();
        if(status==null) {
            bonsais = bonsaiService.findAll();
        }
        else {
            bonsais = bonsaiService.findAll(status);
        }
        return BonsaiMapper.mapModels(bonsais);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findBonsaiById(@PathVariable("uuid") UUID uuid) throws URISyntaxException{
        Optional<Bonsai>ob=bonsaiService.findById(uuid);
        return ResponseEntity.ok(BonsaiMapper.mapModelToDto(ob.get()));
    }

    @PostMapping
    public ResponseEntity<BonsaiDTO> createBonsai(@RequestBody BonsaiDTO bonsaiDTO) throws URISyntaxException {
        Bonsai bo=bonsaiService.create(BonsaiMapper.mapDtoToModel(bonsaiDTO));
        return ResponseEntity.created(new URI("")).body(BonsaiMapper.mapModelToDto(bo));
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> updateBonsai(@RequestBody BonsaiDTO bonsaiDTO,@PathVariable("uuid") UUID uuid) {
        Bonsai bonsaiToUpdate = bonsaiService.update(BonsaiMapper.mapDtoToModel(bonsaiDTO),uuid);
            BonsaiDTO updatedBonsai = BonsaiMapper.mapModelToDto(bonsaiToUpdate);
        return ResponseEntity.ok(updatedBonsai);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteBonsai(@PathVariable("uuid") UUID uuid) {
        bonsaiService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{uuid}/{status}")
    public ResponseEntity<Void> changeStatus(@PathVariable("uuid") UUID uuid,@PathVariable("status") String status) {
        bonsaiService.replaceStatus(uuid,status);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/care-events")
    public List<CareEventDTO>findAllEventsById(@PathVariable("id") UUID bonsai_id, @RequestParam(required = false, name = "type") String type) {
        List<CareEvent>allEvent=new ArrayList<CareEvent>();
        if(type==null) {
            allEvent = bonsaiService.findAllEventsById(bonsai_id);
        }
        else {
            allEvent = bonsaiService.findAllEventsById(bonsai_id, type);
        }
        return CareEventMapper.mapModels(allEvent);
    }


    @PostMapping("/{id}")
    public ResponseEntity<CareEventDTO> createEvent(@RequestBody CareEventDTO careEventDto) throws URISyntaxException {
        CareEvent careEventCreated = bonsaiService.createEvent(CareEventMapper.mapDtoToModel(careEventDto));
        return ResponseEntity.created(new URI("")).body(CareEventMapper.mapModelToDto(careEventCreated));
    }

    @DeleteMapping("/{id}/care-events/{event-id}")
    public ResponseEntity<Void> deleteCareEvent(@PathVariable("event-id") UUID event_id, @PathVariable("id") UUID bonsai_id) {
        Optional<CareEvent> c = bonsaiService.findEventById(event_id);
        Optional<Bonsai> b = bonsaiService.findById(bonsai_id);
        if (b==null || !c.get().getBonsai_id().equals(bonsai_id) ){
            return ResponseEntity.notFound().build();
        }
        bonsaiService.deleteEvent(event_id, bonsai_id);
        return ResponseEntity.noContent().build();
    }

}
