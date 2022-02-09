package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {

    @Query(value="SELECT * FROM progweb.bonsai where progweb.bonsai.status=:status", nativeQuery = true)
    List<BonsaiEntity> findAll(@Param("status")String status);

    @Query(value="SELECT * FROM progweb.bonsai where progweb.bonsai.owner_id=:owner_id", nativeQuery = true)
    List<BonsaiEntity> findBonsaisById(@Param("owner_id") UUID owner_id);

    @Transactional
    @Modifying
    @Query(value="UPDATE progweb.bonsai set owner_id=:uuid where id= :bonsai", nativeQuery = true)
    void addBonsai(@Param("uuid")UUID ownerID, @Param("bonsai") UUID bonsai_id);

    @Transactional
    @Modifying
    @Query(value="UPDATE progweb.bonsai set owner_id=:new_owner_id where id=:bonsai_id", nativeQuery = true)
    void transferBonsai(UUID bonsai_id, UUID new_owner_id);

}

