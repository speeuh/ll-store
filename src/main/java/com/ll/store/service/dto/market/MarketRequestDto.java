package com.ll.store.service.dto.market;

import com.ll.store.repository.entity.market.Market;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketRequestDto {

    private String name;
    private String address;
    private String number;
    private String workingTime;
    private String cnpj;

    public MarketRequestDto(String name, String address, String number, String workingTime, String cnpj) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.workingTime = workingTime;
        this.cnpj = cnpj;
    }

    public Market convertDtoToEntity(){
        return new Market(name, address, number, workingTime, cnpj);
    }
}
