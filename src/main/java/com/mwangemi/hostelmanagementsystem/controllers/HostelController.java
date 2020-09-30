package com.mwangemi.hostelmanagementsystem.controllers;
import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Hostel;


import com.mwangemi.hostelmanagementsystem.services.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hostels")
public class HostelController {

    private HostelService hostelService;

    @Autowired
    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }


    // CREATE Hostel Record
    @PostMapping("")
    public ResponseEntity create(@RequestBody Hostel hostel) {
        GenericResponse genericResponse = hostelService.save(hostel);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // READ ONE Hostel Record
    @GetMapping("/{id}")
    public ResponseEntity getHostel(@PathVariable("id") Long id) {
        GenericResponse genericResponse = hostelService.findById(id);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // READ ALL Hostel Records
    @GetMapping("")
    public ResponseEntity getHostels(){
        GenericResponse genericResponse = hostelService.findAll();
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

     // UPDATE Hostel Record
    @PutMapping("/{id}")
    public ResponseEntity updateHostel(@PathVariable("id") Long id, @RequestBody Hostel hostel){
        GenericResponse genericResponse = hostelService.update(id,hostel);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

     // DELETE Hostel Record
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id) {
        hostelService.deleteById(id);
    }



}

