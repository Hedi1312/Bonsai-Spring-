package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository=ownerRepository;
    }

    public List<Owner> findAll() {
        return ownerRepository.findAllOwners();
    }

    public Optional<Owner> findById(UUID uuid) {
        return ownerRepository.findById(uuid);
    }

    public Owner create(Owner owner) {
        return ownerRepository.create(owner);
    }

    public List<Bonsai>findBonsaisByOwner(UUID uuid) {
        return ownerRepository.findBonsaisByOwner(uuid);
    }

    public Bonsai transferBonsai(UUID owner_id, UUID bonsai_id, UUID new_owner_id) {
        return ownerRepository.transferBonsai(owner_id,bonsai_id,new_owner_id);
    }

    public void addBonsai(UUID uuid, List<UUID> bonsai_id) {
        ownerRepository.addBonsai(uuid,bonsai_id);
    }


}
