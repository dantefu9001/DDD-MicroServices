package com.thoughtworks.sample.ddd.zn.infrastructure.donation.po;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.model.User;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.DonationStatus;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.DonationType;
import com.thoughtworks.ddd.sample.zn.charity.domain.donation.model.Receipt;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "donation")
public class DonationPo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private User donor;

    private DonationType donationType;

    private DonationStatus donationStatus;

    private Date donateTime;

    private User recipient;

    private Receipt receipt;
}
