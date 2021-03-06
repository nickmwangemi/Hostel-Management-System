package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Tenant;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface TenantService {
    GenericResponse save(Tenant tenant);

    GenericResponse listAll();

    GenericResponse get(Long id);

    GenericResponse update(Long id, Tenant tenant);

    GenericResponse delete(Long id);
}
