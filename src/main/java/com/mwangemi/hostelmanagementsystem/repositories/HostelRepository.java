package com.mwangemi.hostelmanagementsystem.repositories;

import com.mwangemi.hostelmanagementsystem.models.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HostelRepository extends JpaRepository<Hostel, Long> {

    void deleteById(Long id);


}


