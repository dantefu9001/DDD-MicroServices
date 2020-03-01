package com.thoughtworks.ddd.sample.zn.charity.domain.donation.model;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class Receipt {
    private String id;

    private Date time;

    private User donor;
}
