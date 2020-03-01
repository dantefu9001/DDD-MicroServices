package com.thoughtworks.ddd.sample.zn.charity.domain.donation.model;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.model.User;
import lombok.Data;

@Data
public class ThanksLetter {
    private String id;

    private User donor;

    private String content;
}
