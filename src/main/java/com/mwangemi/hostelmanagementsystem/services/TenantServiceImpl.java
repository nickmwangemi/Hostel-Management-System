package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
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
        return new GenericResponse(400,"No Data Found");
    }

    @Override
    public GenericResponse save(Tenant tenant) {
        Tenant tenantToSave = tenantRepository.save(tenant);
        if (tenantToSave.getId() > 0) {
            return new GenericResponse(200, "Request Successful. Tenant record created.", tenantToSave);
        }
        return new GenericResponse(400, "Not Saved");
    }

    @Override
    public GenericResponse get(Long id) {
        Optional<Tenant> tenantOptional = tenantRepository.findById(id);
        if (tenantOptional.isPresent())
            return new GenericResponse(200,"Request Successful. Tenant record fetched.",tenantOptional);
        return new GenericResponse(400,"Request Failed! No Tenant details found or error");
    }

    @Override
    public GenericResponse update(Long id, Tenant tenant) {
        Optional<Tenant> tenantToUpdate = tenantRepository.findById(id);
        if(tenantToUpdate.isPresent()){
          tenantToUpdate.get().setFullName(tenant.getFullName());
          tenantToUpdate.get().setEmail(tenant.getEmail());
          tenantToUpdate.get().setMobileNumber(tenant.getMobileNumber());

          Tenant updated = tenantRepository.save(tenantToUpdate.get());
            return new GenericResponse(200,"Request Successful. Tenant record updated.",updated);
        }
        return new GenericResponse(400,"Request Failed! Tenant record not updated.");

    }

    @Override
    public GenericResponse delete(Long id) {
        Optional<Tenant> tenantToDelete = tenantRepository.findById(id);
        if(tenantToDelete.isPresent()){
            tenantRepository.delete(tenantToDelete.get());
            return new GenericResponse(200, "Request Successful. Tenant record deleted.");
        }
        return new GenericResponse(400, "Request Failed! Tenant record not deleted");
    }
}
