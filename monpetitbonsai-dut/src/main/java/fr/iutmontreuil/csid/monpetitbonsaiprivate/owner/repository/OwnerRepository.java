package fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.repository;

import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.BonsaiEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerDao;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence.OwnerEntity;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.BonsaiMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.OwnerMapper;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Bonsai;
import fr.iutmontreuil.csid.monpetitbonsaiprivate.owner.domain.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public class OwnerRepository {

    private final OwnerDao ownerDao;
    private final BonsaiDao bonsaiDao;

    public OwnerRepository(OwnerDao ownerDao, BonsaiDao bonsaiDao) {
        this.ownerDao = ownerDao;
        this.bonsaiDao = bonsaiDao;
    }

    public List<Owner> findAllOwners() {
        List<OwnerEntity> owners = ownerDao.findAll();
        return OwnerMapper.mapEntities(owners);
    }

    public Optional<Owner> findById(UUID uuid) {
        Optional<OwnerEntity> entity = ownerDao.findById(uuid);
        return entity.map(OwnerMapper::mapEntityToModel);
    }

    public Owner create (Owner owner) {
        OwnerEntity ownerToCreate = OwnerMapper.mapModelToEntity(owner);
        OwnerEntity savedOwner = ownerDao.save(ownerToCreate);
        return OwnerMapper.mapEntityToModel(savedOwner);
    }

    public List<Bonsai> findBonsaisByOwner(UUID uuid) {
        List<BonsaiEntity> liste = bonsaiDao.findBonsaisById(uuid);
        return BonsaiMapper.mapEntities(liste);
    }


    public Bonsai transferBonsai(UUID owner_id, UUID bonsai_id, UUID new_owner_id) {
        BonsaiEntity bonsaiEntity = bonsaiDao.findById(bonsai_id).get();
        if(bonsaiEntity.getOwnerEntity().getId().equals(owner_id)){
            bonsaiDao.transferBonsai(bonsai_id,new_owner_id);
            return BonsaiMapper.mapEntityToModel(bonsaiEntity);
        }
        throw new RuntimeException();
    }

    public void addBonsai(UUID ownerID, List<UUID> bonsai_id) {
        for (UUID bonsaiUUID : bonsai_id) {
            BonsaiEntity bonsaiEntity = bonsaiDao.findById(bonsaiUUID).get();
            if (bonsaiEntity.getOwnerEntity() == null) {
                bonsaiDao.addBonsai(ownerID, bonsaiUUID);
            }
        }
    }

}
