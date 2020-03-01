package com.thoughtworks.ddd.sample.zn.charity.domain.material.application.model;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.model.Material;
import lombok.Data;

@Data
public class ApplicationMaterial extends Material {

    private String allocationId;

    private String inboundId;

}
