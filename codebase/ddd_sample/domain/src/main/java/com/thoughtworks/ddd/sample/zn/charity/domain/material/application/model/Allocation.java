package com.thoughtworks.ddd.sample.zn.charity.domain.material.application.model;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.model.User;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
public class Allocation implements Observer {
    private String id;

    private AllocationStatus status;

    private User allocator;

    @Override
    public void update(Observable o, Object arg) {
        this.status = AllocationStatus.OUTBOUND;
    }
}
