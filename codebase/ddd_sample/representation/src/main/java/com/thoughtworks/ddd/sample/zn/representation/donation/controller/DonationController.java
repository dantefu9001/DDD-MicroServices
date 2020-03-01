package com.thoughtworks.ddd.sample.zn.representation.donation.controller;

import com.thoughtworks.ddd.sample.zn.charity.application.donation.command.CreateDonationCommand;
import com.thoughtworks.ddd.sample.zn.charity.application.donation.dto.DonationDto;
import com.thoughtworks.ddd.sample.zn.charity.application.donation.service.DonationService;
import com.thoughtworks.ddd.sample.zn.representation.donation.request.CreateDonationRequest;
import com.thoughtworks.ddd.sample.zn.representation.donation.response.CreateDonationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/donation")
@Api(value = "donation api")
public class DonationController {

    private final DonationService donationService;

    @Autowired
    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "create a donation")
    public ResponseEntity<CreateDonationResponse> create(@RequestBody @Valid CreateDonationRequest request) {
        DonationDto donationDto = donationService.createDonation(new CreateDonationCommand());
        return ResponseEntity.ok(new CreateDonationResponse(donationDto.getId()));
    }
}
