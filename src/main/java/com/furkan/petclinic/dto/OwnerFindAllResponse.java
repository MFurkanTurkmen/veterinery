package com.furkan.petclinic.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class OwnerFindAllResponse {
    String ad;
@JsonCreator
    public OwnerFindAllResponse(String ad) {
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
