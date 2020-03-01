package com.thoughtworks.ddd.sample.zn.charity.domain.donation.repository;

import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Donation;

public interface DonationRepository {

    void save(Donation donation);
}
