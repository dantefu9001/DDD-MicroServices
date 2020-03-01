package com.thoughtworks.sample.ddd.zn.infrastructure.donation.repository.jpa;

import com.thoughtworks.sample.ddd.zn.infrastructure.donation.po.DonationPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationJpaRepository extends JpaRepository<DonationPo, Long> {
}
