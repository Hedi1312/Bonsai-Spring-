package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.BonsaiMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.OwnerService;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.OwnerService;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.BonsaiDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.exposition.dto.OwnerDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owners")
public class OwnerControler {
    private final OwnerService ownerService;

    public OwnerControler(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDTO> findAllOwners() {
        List<Owner> owners = ownerService.findAll();
        return OwnerMapper.mapModels(owners);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OwnerDTO> findOwnerById(@PathVariable("uuid") UUID uuid) {
        Optional<Owner> own = ownerService.findById(uuid);
        return ResponseEntity.ok(OwnerMapper.mapModelToDto(own.get()));
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO) throws URISyntaxException {
        Owner own = ownerService.create(OwnerMapper.mapDtoToModel(ownerDTO));
        return ResponseEntity.created(new URI("")).body(OwnerMapper.mapModelToDto(own));
    }

    @GetMapping("/{uuid}/{bonsai}")
    public List<BonsaiDTO> findBonsaisByOwner(@PathVariable("uuid") UUID uuid) {
        List<Bonsai> bonsais = ownerService.findBonsaisByOwner(uuid);
        return BonsaiMapper.mapModels(bonsais);
    }


    @PostMapping("/owner/{owner_id}/bonsais/{bonsai_id}/transfer")
    public ResponseEntity<BonsaiDTO>transferBonsai(@PathVariable("owner_id")UUID owner_id, @PathVariable("bonsai_id")UUID bonsai_id, @RequestBody OwnerDTO newOwner) throws URISyntaxException {
        Bonsai bonsai=ownerService.transferBonsai(owner_id,bonsai_id,newOwner.getId());
        return ResponseEntity.created(new URI("")).body(BonsaiMapper.mapModelToDto(bonsai));
    }


    @PostMapping("/owner/{owner_id}/bonsais")
    public ResponseEntity<Void> addBonsai(@PathVariable("owner_id") UUID uuid, @RequestBody List<String> listeBonsaiId) {
        List<UUID> lesID = listeBonsaiId.stream()
                .map(x->UUID.fromString(x))
                .collect(Collectors.toList());
        ownerService.addBonsai(uuid, lesID);
        return ResponseEntity.noContent().build();
    }

}
