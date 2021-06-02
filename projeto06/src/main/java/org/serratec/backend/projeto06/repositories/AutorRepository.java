package org.serratec.backend.projeto06.repositories;

import org.serratec.backend.projeto06.entities.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long>{

}
