package com.mwangemi.hostelmanagementsystem.controllers;

import com.mwangemi.hostelmanagementsystem.models.Allocation;
import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.services.AllocationService;
import com.mwangemi.hostelmanagementsystem.services.AllocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allocations")
public class AllocationController {

    private AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    // CREATE Allocation Record
    @PostMapping("")
    public ResponseEntity create(@RequestBody Allocation allocation) {
        GenericResponse genericResponse = allocationService.save(allocation);
        return new ResponseEntity<>(genericResponse, HttpStatus.CREATED);
    }

    // READ ONE Allocation Record
    @GetMapping("/{id}")
    public ResponseEntity getAllocation(@PathVariable("id") Long id) {
        GenericResponse genericResponse = allocationService.get(id);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // READ ALL Allocation Records
    @GetMapping("")
    public ResponseEntity getAllocations(){
        GenericResponse genericResponse = allocationService.listAll();
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // UPDATE Allocation Record
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Allocation allocation){
        GenericResponse genericResponse = allocationService.update(id, allocation);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // DELETE Allocation Record
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        GenericResponse genericResponse = allocationService.deleteById(id);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

}
