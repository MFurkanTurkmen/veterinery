package com.furkan.petclinic.controller;

import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.OwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Owner")
@Api(value = "Owner Controller")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;


    //Save Owner
    @PostMapping("/createowner")
    @ApiOperation(value = "/create Owner")
    public ResponseEntity<Owner> createUser(@RequestBody Owner owner){
        Owner resultOwner= ownerService.createUser(owner);
        return ResponseEntity.ok(resultOwner);
    }

    //Get Owner
    @GetMapping("/getowner")
    @ApiOperation(value = "/get Owner")
    public ResponseEntity<List<Owner>> getOwner(){
        List<Owner> resultOwner= ownerService.getOwners();
        return ResponseEntity.ok(resultOwner);

    }

    @PutMapping("/edit/{id}")
    @ApiOperation("/update Owner")
    public ResponseEntity<Owner> updateOwner(@PathVariable("id") long id , @RequestBody Owner owner){

        Owner resultOwner = ownerService.updateOwner(id,owner);
        return ResponseEntity.ok(resultOwner);
    }
}
