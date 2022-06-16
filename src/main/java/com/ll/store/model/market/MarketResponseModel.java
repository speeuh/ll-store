package com.ll.store.model.market;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketResponseModel {

    private long id;
    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private String workingTime;
    private String marketCnpj;

    public MarketResponseModel(long id, String marketName, String marketAddress, String marketNumber, String workingTime, String marketCnpj) {
        this.id = id;
        this.marketName = marketName;
        this.marketAddress = marketAddress;
        this.marketNumber = marketNumber;
        this.workingTime = workingTime;
        this.marketCnpj = marketCnpj;
    }
}
