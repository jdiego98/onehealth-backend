package com.kopidev.onehealthbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LicenseRequest")
public class LicenseRequest {

    @Id
    @GeneratedValue
    private long licenseRequestId;

    private String userIdentity;
    private String nutritionalCode;
    private long dateOfRequest;
    private long resolutionDate;
    private boolean requestState;

}



