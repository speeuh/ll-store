package com.ll.store.service.dto.market;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketUpdateDto {
    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private String workingTime;
    private String marketCnpj;

    public MarketUpdateDto(String marketName, String marketAddress, String marketNumber, String workingTime, String marketCnpj) {
        this.marketName = marketName;
        this.marketAddress = marketAddress;
        this.marketNumber = marketNumber;
        this.workingTime = workingTime;
        this.marketCnpj = marketCnpj;
    }
}
