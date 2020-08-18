package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Hostel;
import com.mwangemi.hostelmanagementsystem.repositories.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelServiceImpl implements HostelService {

    HostelRepository hostelRepository;

    @Autowired
    public HostelServiceImpl(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }

    @Override
    public GenericResponse findAll() {
        List<Hostel> hostelList=hostelRepository.findAll();
        if (hostelList.size() > 0){
            return new GenericResponse(200,"Request Successful. Fetched hostels.",hostelList);
        }
        return new GenericResponse(200,"No Data Found");
    }

    @Override
    public GenericResponse save(Hostel hostel) {
        Hostel hostelToSave = hostelRepository.save(hostel);
        if (hostelToSave.getId() > 0) {
            return new GenericResponse(200, "Request Successful. Hostel Created", hostelToSave);
        }
        return new GenericResponse(201, "Not Saved");
    }


    @Override
    public GenericResponse findById(Long id) {
        Optional<Hostel> hostelOptional = hostelRepository.findById(id);
        if (hostelOptional.isPresent())
            return new GenericResponse(200,"Request Successful. Hostel record fetched.",hostelOptional);
        return new GenericResponse(201,"Request Failed! No Hostel details found or error");
    }

    @Override
    public GenericResponse deleteById(Long id) {
        hostelRepository.deleteById(id);
        return new GenericResponse(200, "Request Successful. Hostel record deleted.");
    }

    @Override
    public GenericResponse update(Long id) {
        return null;
    }



}



