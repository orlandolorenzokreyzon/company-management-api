package com.kreyzon.companymanagement.api.services.services;

import com.kreyzon.companymanagement.api.common.services.Constant;
import com.kreyzon.companymanagement.api.common.services.GenericResponse;
import com.kreyzon.companymanagement.api.common.services.ProspectDto;
import com.kreyzon.companymanagement.api.services.model.Company;
import com.kreyzon.companymanagement.api.services.model.Prospect;
import com.kreyzon.companymanagement.api.services.repository.CompanyRepository;
import com.kreyzon.companymanagement.api.services.repository.ProspectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProspectService {

    private final ProspectRepository prospectRepository;
    private final CompanyRepository companyRepository;

    public GenericResponse findById(Integer prospectId) {
        Prospect prospect = prospectRepository
                .findById(prospectId)
                .orElseThrow(() -> new IllegalArgumentException("Prospect not found"));

        ProspectDto prospectDto = Prospect.getDtoFromModel(prospect);

        return new GenericResponse(Constant.RESULT_OK, "Prospect found", prospectDto);
    }

    public GenericResponse add(ProspectDto prospectDto) {
        Company company = companyRepository
                .findById(prospectDto.companyId())
                .orElseThrow(() -> new IllegalArgumentException("Company id not found"));

        Prospect prospect = Prospect.getModelFromDto(prospectDto);
        prospect.setId(generateProspectId());
        prospect.setIdCompany(company);

        prospectRepository.save(prospect);

        return new GenericResponse(Constant.RESULT_OK, "Prospect added", prospectDto);
    }

    public GenericResponse update(Integer prospectId, ProspectDto prospectDto) {
        Company company = companyRepository
                .findById(prospectDto.companyId())
                .orElseThrow(() -> new IllegalArgumentException("Company id not found"));

        Prospect prospect = Prospect.getModelFromDto(prospectDto);
        prospect.setId(generateProspectId());
        prospect.setIdCompany(company);

        prospectRepository.save(prospect);

        return new GenericResponse(Constant.RESULT_OK, "Prospect updated", prospectDto);
    }

    public GenericResponse delete(Integer prospectId) {
        Prospect prospect = prospectRepository
                .findById(prospectId)
                .orElseThrow(() -> new IllegalArgumentException("Prospect not found"));

        prospectRepository.delete(prospect);

        return new GenericResponse(Constant.RESULT_OK, "Prospect deleted");
    }

    private Integer generateProspectId() {
        Optional<Prospect> prospectOptional = prospectRepository.findTopByOrderByIdDesc();
        if (prospectOptional.isEmpty())
            return 1;

        return prospectOptional.get().getId() + 1;
    }
}
