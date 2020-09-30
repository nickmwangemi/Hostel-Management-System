package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.*;
import com.mwangemi.hostelmanagementsystem.repositories.AllocationRepository;
import com.mwangemi.hostelmanagementsystem.repositories.BookingRepository;
import com.mwangemi.hostelmanagementsystem.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService {
    private AllocationRepository allocationRepository;
    private BookingRepository bookingRepository;
    private TenantRepository tenantRepository;

    @Autowired
    public AllocationServiceImpl(AllocationRepository allocationRepository, BookingRepository bookingRepository, TenantRepository tenantRepository) {
        this.allocationRepository = allocationRepository;
        this.bookingRepository = bookingRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public GenericResponse save(Allocation allocation) {
        Optional<Booking> booking = bookingRepository.findById(allocation.getBooking().getId());
        Optional<Tenant> tenant = tenantRepository.findById(allocation.getTenant().getId());

        if (booking.isPresent() && tenant.isPresent()) {
            allocation.setBookingStatus(allocation.getBookingStatus());
            allocation.setBooking(booking.get());
            allocation.setTenant(tenant.get());
            allocationRepository.save(allocation);

            return new GenericResponse(200, "Request Successful. Allocation Created", allocation);
        }
        return new GenericResponse(400, "Not Saved");
    }

    @Override
    public GenericResponse listAll() {
        List<Allocation> allocationList = allocationRepository.findAll();
        if(allocationList.size() > 0){
            return new GenericResponse(200, "Request Successful. Allocations fetched.",allocationList);
        }
        return new GenericResponse(400, "No Data Found.");
    }

    @Override
    public GenericResponse get(Long id) {
        Optional<Allocation> allocationOptional = allocationRepository.findById(id);
        if(allocationOptional.isPresent()){
            return new GenericResponse(200, "Request Successful. Allocation fetched.",allocationOptional);
        }
        return new GenericResponse(400, "No Data Found.");
    }


    @Override
    public GenericResponse update(Long id, Allocation allocation) {
        Optional<Allocation> allocationToUpdate = allocationRepository.findById(id);
        Optional<Booking> booking = bookingRepository.findById(allocation.getBooking().getId());
        Optional<Tenant> tenant = tenantRepository.findById(allocation.getTenant().getId());

        if(allocationToUpdate.isPresent()){
            allocationToUpdate.get().setBookingStatus(allocation.getBookingStatus());
            allocationToUpdate.get().setBooking(booking.get());
            allocationToUpdate.get().setTenant(tenant.get());

            Allocation updated = allocationRepository.save(allocationToUpdate.get());
            return new GenericResponse(200,"Request Successful. Allocation record updated.",updated);
        }
        return new GenericResponse(400,"Request Failed! Allocation record not updated.");
    }

    @Override
    public GenericResponse deleteById(Long id) {
        Optional<Allocation> allocationOptional = allocationRepository.findById(id);
        if (allocationOptional.isPresent()) {
            allocationRepository.delete(allocationOptional.get());
            return new  GenericResponse(200,"Allocation Deleted");
        }
        return new GenericResponse(400, "Request Failed! Not Deleted");
    }
}
