package com.mwangemi.hostelmanagementsystem.repositories;

import com.mwangemi.hostelmanagementsystem.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

//curl -H 'Accept: application/json' -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuaWNrIiwiZXhwIjoxNTk4MDE1NTU2fQ.muq1pdiIFIRLFf067QlqJISWObDJA7KTeHjfo9cw8qEypuiSU_orpd33MyNI2xsmkBB8bH50TLABGPHFxFhq-A" https://localhost:8080/api/v1/tenants
//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuaWNrIiwiZXhwIjoxNTk4MDE1NTU2fQ.muq1pdiIFIRLFf067QlqJISWObDJA7KTeHjfo9cw8qEypuiSU_orpd33MyNI2xsmkBB8bH50TLABGPHFxFhq-A