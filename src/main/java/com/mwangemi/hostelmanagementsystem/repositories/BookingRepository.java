package com.mwangemi.hostelmanagementsystem.repositories;

import com.mwangemi.hostelmanagementsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
