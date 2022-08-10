package com.furkan.petclinic.repository;

import com.furkan.petclinic.repository.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByOwnerNameStartingWith(String name);




}
