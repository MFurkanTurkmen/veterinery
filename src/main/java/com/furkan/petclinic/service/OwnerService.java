package com.furkan.petclinic.service;

import com.furkan.petclinic.dto.response.GetOwnerNameResponse;
import com.furkan.petclinic.dto.response.GetOwnerResponse;
import com.furkan.petclinic.dto.request.CreateOwnerRequest;
import com.furkan.petclinic.repository.entity.Owner;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface OwnerService  {

    List<GetOwnerResponse> getOwners();
    CreateOwnerRequest createOwner(CreateOwnerRequest createOwnerRequest);


    CreateOwnerRequest updateOwner(Long id, CreateOwnerRequest createOwnerRequest);

    Boolean deleteOwner(Long id);

    Optional<Owner> findByOwnerEmailandOwnerPassword(String email, String password);


    List<GetOwnerNameResponse> getOwnersName(String name);


}
