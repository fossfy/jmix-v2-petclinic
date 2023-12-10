package com.fossfy.petclinic.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.util.Objects;
import java.util.UUID;

@JmixEntity
@Embeddable
public class InsuranceMembershipKey {
    @Column
    private UUID petId;

    @Column
    private UUID insuranceCompanyId;

    public UUID getPetId() {
        return petId;
    }

    public void setPetId(UUID petId) {
        this.petId = petId;
    }

    public UUID getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public void setInsuranceCompanyId(UUID insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, insuranceCompanyId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceMembershipKey entity = (InsuranceMembershipKey) o;
        return Objects.equals(this.petId, entity.petId) &&
                Objects.equals(this.insuranceCompanyId, entity.insuranceCompanyId);
    }
}
