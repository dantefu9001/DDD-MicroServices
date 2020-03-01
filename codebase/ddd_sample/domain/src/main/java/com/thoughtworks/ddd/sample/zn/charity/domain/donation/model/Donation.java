package com.thoughtworks.ddd.sample.zn.charity.domain.donation.model;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.model.Material;
import com.thoughtworks.ddd.sample.zn.charity.domain.common.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class Donation {
    private String id;

    private User donor;

    private DonationType donationType;

    private DonationStatus donationStatus;

    private Date donateTime;

    private User recipient;

    private Receipt receipt;

    private Material material;

    private ThanksLetter thanksLetter;
}
