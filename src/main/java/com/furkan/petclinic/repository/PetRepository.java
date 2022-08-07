package com.furkan.petclinic.repository;

import com.furkan.petclinic.repository.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
