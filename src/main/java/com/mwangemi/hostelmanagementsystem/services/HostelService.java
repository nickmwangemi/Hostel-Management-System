package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Hostel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface HostelService {

    GenericResponse findAll();

    GenericResponse save(Hostel hostel);

    GenericResponse deleteById(Long id);

    GenericResponse update(Long id);

    GenericResponse findById(Long id);

}