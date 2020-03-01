package com.thoughtworks.ddd.sample.zn.charity.application.donation.command;

import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Donation;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CreateDonationCommand {

    private Donation donation;
}
