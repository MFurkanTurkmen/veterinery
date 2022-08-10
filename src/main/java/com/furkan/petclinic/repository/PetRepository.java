package com.furkan.petclinic.repository;

import com.furkan.petclinic.repository.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    List<Pet> findByPetNameStartingWith(String name);
}
