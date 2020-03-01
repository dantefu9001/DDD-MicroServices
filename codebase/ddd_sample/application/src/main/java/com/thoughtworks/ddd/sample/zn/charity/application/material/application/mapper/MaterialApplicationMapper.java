package com.thoughtworks.ddd.sample.zn.charity.application.material.application.mapper;

import com.thoughtworks.ddd.sample.zn.charity.application.donation.dto.DonationDto;
import com.thoughtworks.ddd.sample.zn.charity.application.material.application.dto.MaterialApplicationDto;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Donation;
import com.thoughtworks.ddd.sample.zn.charity.domain.material.application.model.MaterialApplication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaterialApplicationMapper {
    MaterialApplicationMapper MAPPER = Mappers.getMapper(MaterialApplicationMapper.class);

    MaterialApplicationDto toDto(MaterialApplication materialApplication);
}
