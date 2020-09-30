package com.mwangemi.hostelmanagementsystem.controllers;
import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Room;
import com.mwangemi.hostelmanagementsystem.repositories.RoomRepository;

import com.mwangemi.hostelmanagementsystem.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // CREATE Room Record
    @PostMapping("")
    public ResponseEntity create(@RequestBody Room room) {
        GenericResponse genericResponse = roomService.save(room);
        return new ResponseEntity<>(genericResponse, HttpStatus.CREATED);
    }

    // READ ONE Room Record
    @GetMapping("/{id}")
    public ResponseEntity getRoom(@PathVariable("id") Long id){
        GenericResponse genericResponse = roomService.get(id);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // READ ALL Room Records
    @GetMapping("")
    public ResponseEntity getRooms(){
        GenericResponse genericResponse = roomService.listAll();
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // UPDATE Room Record
    @PutMapping("/{id}")
    public ResponseEntity updateRoom(@PathVariable("id") Long id, @RequestBody Room room){
        GenericResponse genericResponse = roomService.update(id,room);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

     //DELETE Room Record
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id) {
        roomService.deleteById(id);
    }



}
