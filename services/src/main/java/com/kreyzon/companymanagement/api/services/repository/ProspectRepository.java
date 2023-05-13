package com.kreyzon.companymanagement.api.services.repository;

import com.kreyzon.companymanagement.api.services.model.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProspectRepository extends JpaRepository<Prospect, Integer> {
    Optional<Prospect> findTopByOrderByIdDesc();
}
