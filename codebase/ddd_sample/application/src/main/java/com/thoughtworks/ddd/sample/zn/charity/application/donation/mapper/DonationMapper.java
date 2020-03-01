package com.thoughtworks.ddd.sample.zn.charity.application.donation.mapper;

import com.thoughtworks.ddd.sample.zn.charity.application.donation.dto.DonationDto;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Donation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DonationMapper {
    DonationMapper MAPPER = Mappers.getMapper(DonationMapper.class);

    DonationDto toDto(Donation donation);
}
