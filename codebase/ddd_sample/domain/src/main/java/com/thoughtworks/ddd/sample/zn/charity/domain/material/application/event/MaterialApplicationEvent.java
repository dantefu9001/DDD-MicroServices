package com.thoughtworks.ddd.sample.zn.charity.domain.material.application.event;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.event.BaseEvent;
import com.thoughtworks.ddd.sample.zn.charity.domain.material.application.model.ApplicationStatus;
import com.thoughtworks.ddd.sample.zn.charity.domain.material.application.model.MaterialApplication;

import java.util.Objects;

public class MaterialApplicationEvent extends BaseEvent {

    private MaterialApplication application;

    public MaterialApplicationEvent(MaterialApplication application){
        this.application = application;
        this.addObserver(application);
    }

    public void onApplicationStatusChange(ApplicationStatus status) {
        ApplicationStatus currentStatus = this.application.getStatus();
        if (Objects.isNull(currentStatus) || status.ordinal() - currentStatus.ordinal() == 1) {
            this.application.setStatus(status);
        }
        if (status.equals(ApplicationStatus.APPROVED)) {
            this.notifyObservers();
        }
    }
}
