package com.mwangemi.hostelmanagementsystem.repositories;

import com.mwangemi.hostelmanagementsystem.models.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
