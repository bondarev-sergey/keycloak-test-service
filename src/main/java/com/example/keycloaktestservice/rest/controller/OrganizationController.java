package com.example.keycloaktestservice.rest.controller;

import com.example.keycloaktestservice.rest.dto.Organization;
import com.example.keycloaktestservice.service.OrganizationService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GetMapping("/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(organizationService.getOrganization(organizationId));
    }

    @RolesAllowed({"ADMIN"})
    @PutMapping("/{organizationId}")
    public ResponseEntity<Organization> updateOrganization(
            @PathVariable Long organizationId, @RequestBody Organization organization) {
        organizationService.updateOrganization(organizationId, organization);
        return ResponseEntity.ok(organization);
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.saveOrganization(organization));
    }

}
