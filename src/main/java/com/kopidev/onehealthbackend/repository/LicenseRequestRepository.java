package com.kopidev.onehealthbackend.repository;

import com.kopidev.onehealthbackend.entity.LicenseRequest;
import com.kopidev.onehealthbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRequestRepository extends JpaRepository<LicenseRequest, Long> {
}
