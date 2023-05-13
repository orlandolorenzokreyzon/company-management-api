package com.kreyzon.companymanagement.api.services.model;

import com.kreyzon.companymanagement.api.common.services.CompanyDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id_company", nullable = false)
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "legal_address")
    private String legalAddress;

    @Column(name = "mailing_address")
    private String mailingAddress;

    @Column(name = "tax_id_number")
    private String taxIdNumber;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public static CompanyDto getDtoFromModel(Company company) {
        return new CompanyDto(
                company.getId(),
                company.getCompanyName(),
                company.getLegalAddress(),
                company.getMailingAddress(),
                company.getTaxIdNumber(),
                company.getRegistrationNumber(),
                company.getPhone(),
                company.getEmail()
        );
    }

    public static Company getModelFromDto(CompanyDto companyDto) {
        Company company = new Company();
        company.setCompanyName(companyDto.companyName());
        company.setLegalAddress(companyDto.legalAddress());
        company.setMailingAddress(companyDto.mailingAddress());
        company.setTaxIdNumber(companyDto.taxIdNumber());
        company.setRegistrationNumber(companyDto.registrationNumber());
        company.setPhone(companyDto.phone());
        company.setEmail(companyDto.email());
        return company;
    }
}