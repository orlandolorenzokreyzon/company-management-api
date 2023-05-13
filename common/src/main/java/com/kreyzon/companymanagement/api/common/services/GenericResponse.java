package com.kreyzon.companymanagement.api.common.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {
    private String result;
    private String message;
    private T dto;

    public GenericResponse(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public GenericResponse(String result, String message, T dto) {
        this.result = result;
        this.message = message;
        this.dto = dto;
    }
}
