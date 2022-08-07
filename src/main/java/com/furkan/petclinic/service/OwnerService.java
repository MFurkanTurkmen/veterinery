package com.furkan.petclinic.service;

import com.furkan.petclinic.repository.entity.Owner;

import java.util.List;

public interface OwnerService  {
    Owner createUser(Owner owner);
    List<Owner> getOwners();
    Owner updateOwner(Long id, Owner owner);
}
