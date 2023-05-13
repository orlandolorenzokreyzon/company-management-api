package com.kreyzon.companymanagement.api.common.services;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * A DTO for the {@link com.kreyzon.companymanagement.api.services.model.Prospect} entity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProspectDto(Integer id, String firstName, String lastName, String fullName, String email,
                          String phoneNumber, String platform, String prospectType, Integer companyId) implements Serializable {
}