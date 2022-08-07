package com.furkan.petclinic.controller;

import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.OwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Api(value = "Owner Controller")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;


    //Save Owner
    @PostMapping("/create")
    @ApiOperation(value = "Create Owner")
    public ResponseEntity<Owner> createUser(@RequestBody Owner owner){
        Owner resultOwner= ownerService.createUser(owner);
        return ResponseEntity.ok(resultOwner);
    }

    //Get Owner
    @GetMapping("/getowner")
    @ApiOperation(value = "Get Owner")
    public ResponseEntity<List<Owner>> getOwner(){
        List<Owner> resultOwner= ownerService.getOwners();
        return ResponseEntity.ok(resultOwner);

    }

}
