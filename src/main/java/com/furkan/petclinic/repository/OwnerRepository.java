package com.furkan.petclinic.repository;

import com.furkan.petclinic.repository.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByOwnerNameStartingWith(String name);
    Optional<Owner> findOptionalByOwnerEmailAndOwnerPassword(String email, String password);




}
