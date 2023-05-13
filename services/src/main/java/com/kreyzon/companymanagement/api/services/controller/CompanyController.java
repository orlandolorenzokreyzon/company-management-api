package com.kreyzon.companymanagement.api.services.controller;

import com.kreyzon.companymanagement.api.common.services.CompanyDto;
import com.kreyzon.companymanagement.api.common.services.GenericResponse;
import com.kreyzon.companymanagement.api.services.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{companyId}")
    public ResponseEntity<GenericResponse> findById(@PathVariable Integer companyId) {
        GenericResponse response = companyService.findById(companyId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GenericResponse> add(@RequestBody CompanyDto companyDto) {
        GenericResponse response = companyService.add(companyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<GenericResponse> update(@PathVariable Integer companyId, @RequestBody CompanyDto companyDto) {
        GenericResponse response = companyService.update(companyId, companyDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<GenericResponse> delete(@PathVariable Integer companyId) {
        GenericResponse response = companyService.delete(companyId);
        return ResponseEntity.ok(response);
    }

}
