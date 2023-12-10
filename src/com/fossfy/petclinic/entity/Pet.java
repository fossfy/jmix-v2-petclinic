package com.fossfy.petclinic.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "PETS",uniqueConstraints = {
        @UniqueConstraint(name = "UQ_PET_IDENTIFICATION_NUMBER", columnNames = {"IDENTIFICATION_NUMBER"})
})
@Entity
public class Pet {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;


    @Column(name = "NAME",nullable = false)
    protected String name;

    @InstanceName
    @NotNull
    @Column(name = "IDENTIFICATION_NUMBER", nullable = false)
    protected String identificationNumber;

    @Column(name = "BIRTH_DATE",nullable = false)
    protected LocalDate birthDate;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "pet")
    protected List<InsuranceMembership> insurancesMemberships;

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public List<InsuranceMembership> getInsurancesMemberships() {
        return insurancesMemberships;
    }

    public void setInsurancesMemberships(List<InsuranceMembership> insurancesMemberships) {
        this.insurancesMemberships = insurancesMemberships;
    }
}
