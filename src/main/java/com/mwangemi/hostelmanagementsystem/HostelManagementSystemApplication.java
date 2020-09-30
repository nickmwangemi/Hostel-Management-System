package com.mwangemi.hostelmanagementsystem;

import com.mwangemi.hostelmanagementsystem.models.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HostelManagementSystemApplication {


    public static void main(String[] args) {

        SpringApplication.run(HostelManagementSystemApplication.class, args);
    }

    @GetMapping(value = "/")
    public ResponseEntity welcome(){
        Response response = new Response();
        response.setText("Welcome to the Hostel Management System");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}