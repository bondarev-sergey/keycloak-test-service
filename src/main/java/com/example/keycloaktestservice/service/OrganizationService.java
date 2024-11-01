package com.example.keycloaktestservice.service;

import com.example.keycloaktestservice.rest.dto.Organization;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    public Organization getOrganization(Long organizationId) {
        return new Organization("Organization", "Best organization");
    }

    public void updateOrganization(Long organizationId, Organization organization) {
    }

    public Organization saveOrganization(Organization organization) {
        return new Organization(organization.name(), organization.description());
    }

}
