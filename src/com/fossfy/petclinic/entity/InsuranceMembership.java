package com.fossfy.petclinic.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@JmixEntity
@Table(name = "INSURANCE_MEMBERSHIPS")
@Entity
public class InsuranceMembership {
    @EmbeddedId
    private InsuranceMembershipKey id;


    @MapsId("petId")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PET_ID")
    protected Pet pet;

    @MapsId("insuranceCompanyId")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INSURANCE_COMPANY_ID")
    protected InsuranceCompany insuranceCompany;


    @NotNull
    @Column(name = "VALID_FROM", nullable = false)
    protected LocalDate validFrom;


    @Column(name = "VALID_UNTIL")
    protected LocalDate validUntil;

    public InsuranceMembershipKey getId() {
        return id;
    }

    public void setId(InsuranceMembershipKey id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
        this.id.setPetId(pet == null ? null : pet.getId());
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
        this.id.setInsuranceCompanyId(insuranceCompany == null ? null : insuranceCompany.getId());
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }
}
