package com.kreyzon.companymanagement.api.services.model;

import com.kreyzon.companymanagement.api.common.services.ProspectDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prospect")
public class Prospect {
    @Id
    @Column(name = "id_prospect", nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number", length = Integer.MAX_VALUE)
    private String phoneNumber;

    @Column(name = "platform")
    private String platform;

    @Column(name = "prospect_type")
    private String prospectType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private Company idCompany;

    public static ProspectDto getDtoFromModel(Prospect prospect) {
        return new ProspectDto(
                prospect.getId(),
                prospect.getFirstName(),
                prospect.getLastName(),
                prospect.getFullName(),
                prospect.getEmail(),
                prospect.getPhoneNumber(),
                prospect.getPlatform(),
                prospect.getProspectType(),
                prospect.getIdCompany().getId()
        );
    }

    public static Prospect getModelFromDto(ProspectDto prospectDto) {
        Prospect prospect = new Prospect();
        prospect.setId(prospectDto.id());
        prospect.setFirstName(prospectDto.firstName());
        prospect.setLastName(prospectDto.lastName());
        prospect.setFullName(prospectDto.fullName());
        prospect.setEmail(prospectDto.email());
        prospect.setPhoneNumber(prospectDto.phoneNumber());
        prospect.setPlatform(prospectDto.platform());
        prospect.setProspectType(prospectDto.prospectType());
        return prospect;
    }

}