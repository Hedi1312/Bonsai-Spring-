package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface CareEventDao extends JpaRepository<CareEventEntity, UUID> {

    @Query(value="SELECT * FROM progweb.care_event where bonsai_id=:bonsai_id", nativeQuery = true)
    List<CareEventEntity> findAllEventsById(@Param("bonsai_id")UUID bonsai_id);

    @Query(value="SELECT * FROM progweb.care_event where bonsai_id=:bonsai_id and event_type=:type", nativeQuery = true)
    List<CareEventEntity> findAllEventsById(@Param("bonsai_id")UUID bonsai_id, @Param("type")String type) ;
}
