package com.thoughtworks.ddd.sample.zn.charity.domain.donation.event;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.event.BaseEvent;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Donation;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.DonationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DonationEvent extends BaseEvent {

    private Donation donation;

    @Autowired
    public DonationEvent(Donation donation) {
        this.donation = donation;
    }

    public void onDonationStatusChange(DonationStatus donationStatus){
        this.donation.setDonationStatus(donationStatus);
    }
}
