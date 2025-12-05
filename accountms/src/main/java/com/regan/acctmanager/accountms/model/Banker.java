package com.regan.acctmanager.accountms.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name="banker")
public class Banker {

    @Id
    @GeneratedValue()
    @Column(name = "sysid")
    private UUID sysUUID;

    private String customer_id;

    private String bank_name;

    private String ifsc_code;

    private String branch;

    public UUID getSysUUID() {
        return sysUUID;
    }

    public void setSysUUID(UUID sysUUID) {
        this.sysUUID = sysUUID;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
