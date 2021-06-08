package org.com.serratec.backend.ProjetoCrud04.repository;

import org.com.serratec.backend.ProjetoCrud04.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

}
