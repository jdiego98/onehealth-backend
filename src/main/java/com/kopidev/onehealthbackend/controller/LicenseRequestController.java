package com.kopidev.onehealthbackend.controller;

import com.kopidev.onehealthbackend.entity.LicenseRequest;
import com.kopidev.onehealthbackend.entity.User;
import com.kopidev.onehealthbackend.service.LicenseRequestService;
import com.kopidev.onehealthbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LicenseRequestController {

    @Autowired
    private LicenseRequestService service;

    @RequestMapping(value = "/addLicenseRequest", method = RequestMethod.POST)
    public LicenseRequest addLicenseRequest(@RequestBody LicenseRequest licenseRequest){
        return service.saveLicenseRequest(licenseRequest);
    }

}
