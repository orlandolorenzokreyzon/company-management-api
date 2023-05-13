package com.kreyzon.companymanagement.api.services.services;

import com.kreyzon.companymanagement.api.common.services.CompanyDto;
import com.kreyzon.companymanagement.api.common.services.Constant;
import com.kreyzon.companymanagement.api.common.services.GenericResponse;
import com.kreyzon.companymanagement.api.services.model.Company;
import com.kreyzon.companymanagement.api.services.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public GenericResponse findById(Integer companyId) {
        Company company = companyRepository
                .findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        CompanyDto companyDto = Company.getDtoFromModel(company);

        return new GenericResponse(Constant.RESULT_OK, "Company found", companyDto);
    }

    public GenericResponse add(CompanyDto companyDto) {
        Company company = Company.getModelFromDto(companyDto);
        company.setId(generateCompanyId());

        companyRepository.save(company);

        return new GenericResponse(Constant.RESULT_OK, "Company created", companyDto);
    }

    public GenericResponse update(Integer companyId, CompanyDto companyDto) {
        Company company = Company.getModelFromDto(companyDto);
        company.setId(companyId);

        companyRepository.save(company);

        return new GenericResponse(Constant.RESULT_OK, "Company updated", companyDto);
    }

    public GenericResponse delete(Integer companyId) {
        Company company = companyRepository
                .findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        companyRepository.delete(company);

        return new GenericResponse(Constant.RESULT_OK, "Company deleted");
    }

    private Integer generateCompanyId() {
        Optional<Company> companyOptional = companyRepository.findTopByOrderByIdDesc();
        if (companyOptional.isEmpty())
            return 1;

        return companyOptional.get().getId() + 1;
    }
}
