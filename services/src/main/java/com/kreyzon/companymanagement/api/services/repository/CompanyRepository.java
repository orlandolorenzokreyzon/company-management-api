package com.kreyzon.companymanagement.api.services.repository;

import com.kreyzon.companymanagement.api.services.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findTopByOrderByIdDesc();
}
