package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Tenant;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public interface TenantService {
    GenericResponse listAll();

    GenericResponse save(Tenant tenant);

    GenericResponse get(Long id);

    GenericResponse deleteById(Long id);

    GenericResponse update(Long id);
}