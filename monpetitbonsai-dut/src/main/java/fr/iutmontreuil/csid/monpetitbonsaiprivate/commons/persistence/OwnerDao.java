package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.persistence;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.UUID;

@Component
public interface OwnerDao extends JpaRepository<OwnerEntity, UUID> {

}
