package com.thoughtworks.ddd.sample.zn.charity.application.donation.dto;

import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.DonationStatus;
import lombok.Data;

@Data
public class DonationDto {

    private String id;

    private DonationStatus status;
}
