package org.com.serratec.backend.ProjetoCrud04.repository;

import org.com.serratec.backend.ProjetoCrud04.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {

}
