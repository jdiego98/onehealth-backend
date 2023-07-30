package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.entity.LicenseRequest;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.repository.LicenseRequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LicenseRequestService {

    @Autowired
    private LicenseRequestRepository repository;

    public LicenseRequest saveLicenseRequest(LicenseRequest licenseRequest){
        return repository.save(licenseRequest);
    }

//    public List<LicenseRequest> getLicenseRequest(){
//        return repository.findAll();
//    }
//
//    public LicenseRequest getLicenseRequestById(long id){
//        return repository.findById(id).orElse(null);
//    }
//
//    public  String deleteLicenseRequest(long id){
//        repository.deleteById(id);
//        return "license removed";
//    }
//
//    public LicenseRequest updateLicenseRequest(LicenseRequest licenseRequest){
//        LicenseRequest licenseRequest = repository.findById(licenseRequest.getId()).orElse(null);
//        licenseRequest.se
//
//        return  repository.save(existingUser);
//    }

}
