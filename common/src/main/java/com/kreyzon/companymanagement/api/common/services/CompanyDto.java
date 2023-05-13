package com.kreyzon.companymanagement.api.common.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * A DTO for the {@link Company} entity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CompanyDto(Integer id, String companyName, String legalAddress, String mailingAddress, String taxIdNumber,
                         String registrationNumber, String phone, String email) implements Serializable {
}