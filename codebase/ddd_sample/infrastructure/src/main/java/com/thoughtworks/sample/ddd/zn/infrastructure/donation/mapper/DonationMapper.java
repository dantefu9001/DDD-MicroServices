package com.thoughtworks.sample.ddd.zn.infrastructure.donation.mapper;

import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Donation;
import com.thoughtworks.sample.ddd.zn.infrastructure.donation.po.DonationPo;
import org.mapstruct.factory.Mappers;

public interface DonationMapper {
    DonationMapper MAPPER = Mappers.getMapper(DonationMapper.class);

    DonationPo toDonationPo(Donation donation);

    Donation toDonation(DonationPo donationPo);
}
