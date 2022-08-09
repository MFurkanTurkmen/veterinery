package com.furkan.petclinic.controller;

import com.furkan.petclinic.dto.response.GetOwnerResponse;
import com.furkan.petclinic.dto.request.CreateOwnerRequest;
import com.furkan.petclinic.service.OwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
@Api(value = "owner controller")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;


    @PostMapping("/createowner")
    @ApiOperation(value = "/create owner")
    public ResponseEntity<CreateOwnerRequest> createUser(@RequestBody CreateOwnerRequest createOwnerRequest){
        CreateOwnerRequest resultOwner= ownerService.createOwner(createOwnerRequest);
        return ResponseEntity.ok(resultOwner);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("/update Owner")
    public ResponseEntity<CreateOwnerRequest> updateOwner(@PathVariable("id") long id , @RequestBody CreateOwnerRequest createOwnerRequest){
        CreateOwnerRequest resultOwner = ownerService.updateOwner(id,createOwnerRequest);
        return ResponseEntity.ok(resultOwner);
    }

    @DeleteMapping("/edit/{id}")
    @ApiOperation(value ="/delete owner" )
    public ResponseEntity<Boolean> deleteOwner(@PathVariable ("id") long id){
        Boolean status = ownerService.deleteOwner(id);
        return ResponseEntity.ok(status);

    }

    @GetMapping("/getowner")
    @ApiOperation(value = "/get Owner")
    public ResponseEntity<List<GetOwnerResponse>> getOwner(){
        List<GetOwnerResponse> resultOwner= ownerService.getOwners();
        return ResponseEntity.ok(resultOwner);

    }




}
