package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Hostel;
import com.mwangemi.hostelmanagementsystem.models.Room;
import com.mwangemi.hostelmanagementsystem.models.Tenant;
import com.mwangemi.hostelmanagementsystem.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {

    private TenantRepository tenantRepository;

    @Autowired
    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public GenericResponse listAll() {
        List<Tenant> tenantList=tenantRepository.findAll();
        if (tenantList.size() > 0){
            return new GenericResponse(200,"Request Successful. Fetched tenants.",tenantList);
        }
        return new GenericResponse(200,"No Data Found");
    }


    @Override
    public GenericResponse save(Tenant tenant) {
        Tenant tenantToSave = tenantRepository.save(tenant);
        if (tenantToSave.getId() > 0) {
            return new GenericResponse(200, "Request Successful. Tenant record created.", tenantToSave);
        }
        return new GenericResponse(201, "Not Saved");
    }

    @Override
    public GenericResponse get(Long id) {
        Optional<Tenant> tenantOptional = tenantRepository.findById(id);
        if (tenantOptional.isPresent())
            return new GenericResponse(200,"Request Successful. Tenant record fetched.",tenantOptional);
        return new GenericResponse(201,"Request Failed! No Tenant details found or error");
    }

    @Override
    public GenericResponse deleteById(Long id) {
        return null;
    }

    @Override
    public GenericResponse update(Long id) {
        return null;
    }
}
