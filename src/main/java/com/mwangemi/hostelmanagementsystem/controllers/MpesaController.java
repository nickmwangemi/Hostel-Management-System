package com.mwangemi.hostelmanagementsystem.controllers;

import com.mwangemi.hostelmanagementsystem.models.MpesaConfig.Constants;
import com.mwangemi.hostelmanagementsystem.models.MpesaConfig.Mpesa;
import com.mwangemi.hostelmanagementsystem.models.StkRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/mpesa")
public class MpesaController {

    Mpesa mpesa = new Mpesa(Constants.APP_KEY,Constants.APP_SECRET);

    @GetMapping("/fetch-access-token")
    public ResponseEntity fetchAccessToken() throws IOException {
        String response = mpesa.authenticate();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/stk-request")
    public ResponseEntity stkRequest(@RequestBody StkRequest stkRequest) throws IOException {
        String response = mpesa.STKPushSimulation(stkRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/callback")
    public ResponseEntity callBack(){
        return new ResponseEntity(HttpStatus.OK);
    }

}
