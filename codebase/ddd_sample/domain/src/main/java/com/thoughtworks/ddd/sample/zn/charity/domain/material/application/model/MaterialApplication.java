package com.thoughtworks.ddd.sample.zn.charity.domain.material.application.model;

import com.thoughtworks.ddd.sample.zn.charity.domain.common.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

@Getter
@NoArgsConstructor
public class MaterialApplication implements Observer {

    private String id;

    private String applyTime;

    private Applicant applicant;

    private ApplicationStatus status;

    private String transferAccount;

    private String address;

    private User approver;

    private List<ApplicationMaterial> applicationMaterialList;

    private Allocation allocation;

    @Override
    public void update(Observable o, Object arg) {
        this.allocation = new Allocation();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void setTransferAccount(String transferAccount) {
        this.transferAccount = transferAccount;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

    public void setApplicationMaterialList(List<ApplicationMaterial> applicationMaterialList) {
        this.applicationMaterialList = applicationMaterialList;
    }
}
