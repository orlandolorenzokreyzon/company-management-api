package com.kreyzon.companymanagement.api.services.controller;

import com.kreyzon.companymanagement.api.common.services.GenericResponse;
import com.kreyzon.companymanagement.api.common.services.ProspectDto;
import com.kreyzon.companymanagement.api.services.services.ProspectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prospect")
@RequiredArgsConstructor
public class ProspectController {

    private final ProspectService prospectService;

    @GetMapping("/{prospectId}")
    public GenericResponse findById(@PathVariable Integer prospectId) {
        return prospectService.findById(prospectId);
    }

    @PostMapping
    public GenericResponse add(@RequestBody ProspectDto prospectDto) {
        return prospectService.add(prospectDto);
    }

    @PutMapping("/{prospectId}")
    public GenericResponse update(@PathVariable Integer prospectId, @RequestBody ProspectDto prospectDto) {
        return prospectService.update(prospectId, prospectDto);
    }

    @DeleteMapping("/{prospectId}")
    public GenericResponse delete(@PathVariable Integer prospectId) {
        return prospectService.delete(prospectId);
    }
}
