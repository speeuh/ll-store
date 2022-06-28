package com.ll.store.model.market;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketResponseModel {

    private String id;
    private String name;
    private String address;
    private String number;
    private String workingTime;
    private String cnpj;

    public MarketResponseModel(String id, String name, String address, String number, String workingTime, String cnpj) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.workingTime = workingTime;
        this.cnpj = cnpj;
    }
}
