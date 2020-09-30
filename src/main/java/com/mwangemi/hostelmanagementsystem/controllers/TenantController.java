package com.mwangemi.hostelmanagementsystem.controllers;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Tenant;
import com.mwangemi.hostelmanagementsystem.services.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tenants")
public class TenantController {

    private TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    // CREATE Tenant Record
    @PostMapping("")
    public ResponseEntity create(@RequestBody Tenant tenant) {
        GenericResponse genericResponse = tenantService.save(tenant);
        return new ResponseEntity<>(genericResponse, HttpStatus.CREATED);
    }

    // READ ONE Tenant Record
    @GetMapping("/{id}")
    public ResponseEntity getTenant(@PathVariable("id") Long id){
        GenericResponse genericResponse = tenantService.get(id);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // READ ALL Tenant Records
    @GetMapping("")
    public ResponseEntity getTenants(){
        GenericResponse genericResponse =  tenantService.listAll();
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // UPDATE Tenant Record
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Tenant tenant){
        GenericResponse genericResponse = tenantService.update(id,tenant);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // DELETE Tenant Record
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        GenericResponse genericResponse = tenantService.delete(id);
        return new ResponseEntity<>(genericResponse,HttpStatus.OK);
    }

}
