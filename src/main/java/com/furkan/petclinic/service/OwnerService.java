package com.furkan.petclinic.service;

import com.furkan.petclinic.dto.response.GetOwnerResponse;
import com.furkan.petclinic.dto.request.CreateOwnerRequest;

import java.util.List;

public interface OwnerService  {
    CreateOwnerRequest createOwner(CreateOwnerRequest createOwnerRequest);
    List<GetOwnerResponse> getOwners();
    CreateOwnerRequest updateOwner(Long id, CreateOwnerRequest createOwnerRequest);
    Boolean deleteOwner(Long id);

}
