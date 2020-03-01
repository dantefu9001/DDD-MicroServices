package com.thoughtworks.ddd.sample.zn.charity.domain.material.application.event;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.event.BaseEvent;
import com.thoughtworks.ddd.sample.zn.charity.domain.material.application.model.ApplicationMaterial;
import com.thoughtworks.ddd.sample.zn.charity.domain.material.application.model.MaterialApplication;
import org.springframework.stereotype.Component;

public class MaterialEvent extends BaseEvent {

    private ApplicationMaterial material;

    public MaterialEvent(ApplicationMaterial material, MaterialApplication materialApplication){
        this.material = material;
        this.addObserver(materialApplication.getAllocation());
    }

    public void onMaterialWithEnoughInventory(){
        this.notifyObservers();
    }
}
