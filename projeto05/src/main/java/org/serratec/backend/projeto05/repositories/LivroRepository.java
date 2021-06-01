package org.serratec.backend.projeto05.repositories;

import org.serratec.backend.projeto05.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

}
