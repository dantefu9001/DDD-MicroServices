package com.thoughtworks.sample.ddd.zn.infrastructure.donation.repository;

import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Donation;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.repository.DonationRepository;
import com.thoughtworks.sample.ddd.zn.infrastructure.donation.mapper.DonationMapper;
import com.thoughtworks.sample.ddd.zn.infrastructure.donation.po.DonationPo;
import com.thoughtworks.sample.ddd.zn.infrastructure.donation.repository.jpa.DonationJpaRepository;

public class DonationRepositoryImpl implements DonationRepository {

    private DonationJpaRepository jpaRepository;

    @Override
    public void save(Donation donation) {
        DonationPo po = DonationMapper.MAPPER.toDonationPo(donation);
        this.jpaRepository.save(po);
    }
}
