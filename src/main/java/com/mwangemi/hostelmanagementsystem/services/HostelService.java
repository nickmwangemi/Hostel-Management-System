package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Hostel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface HostelService {

    GenericResponse save(Hostel hostel);

    GenericResponse findAll();

    GenericResponse findById(Long id);

    GenericResponse update(Long id, Hostel hostel);

    GenericResponse deleteById(Long id);


}