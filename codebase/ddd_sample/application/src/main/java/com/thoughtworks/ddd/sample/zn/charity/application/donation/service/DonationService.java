package com.thoughtworks.ddd.sample.zn.charity.application.donation.service;

import com.thoughtworks.ddd.sample.zn.charity.application.donation.command.CreateDonationCommand;
import com.thoughtworks.ddd.sample.zn.charity.application.donation.dto.DonationDto;
import com.thoughtworks.ddd.sample.zn.charity.application.donation.mapper.DonationMapper;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.event.DonationEvent;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Donation;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.DonationStatus;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.repository.DonationRepository;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

    private DonationRepository repository;
    private DonationEvent event;

    public DonationDto createDonation(CreateDonationCommand command) {
        Donation donation = repository.save(command.getDonation());
        event.onDonationStatusChange(DonationStatus.CREATED);
        return DonationMapper.MAPPER.toDto(donation);
    }
}
