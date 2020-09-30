package com.mwangemi.hostelmanagementsystem.repositories;

import com.mwangemi.hostelmanagementsystem.models.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}
