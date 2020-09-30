package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.Allocation;
import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import org.springframework.stereotype.Service;

@Service
public interface AllocationService {
    GenericResponse save(Allocation allocation);

    GenericResponse listAll();

    GenericResponse get(Long id);

    GenericResponse update(Long id, Allocation allocation);

    GenericResponse deleteById(Long id);

}
