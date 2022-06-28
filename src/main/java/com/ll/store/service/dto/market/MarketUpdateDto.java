package com.ll.store.service.dto.market;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketUpdateDto {

    private String name;
    private String address;
    private String number;
    private String workingTime;
    private String cnpj;

    public MarketUpdateDto(String name, String address, String number, String workingTime, String cnpj) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.workingTime = workingTime;
        this.cnpj = cnpj;
    }
}
