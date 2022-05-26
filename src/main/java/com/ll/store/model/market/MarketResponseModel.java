package com.ll.store.model.market;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MarketResponseModel {

    private long id;
    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private Date workingTime;
    private long marketCnpj;

    public MarketResponseModel(long id, String marketName, String marketAddress, String marketNumber, Date workingTime, long marketCnpj) {
        this.id = id;
        this.marketName = marketName;
        this.marketAddress = marketAddress;
        this.marketNumber = marketNumber;
        this.workingTime = workingTime;
        this.marketCnpj = marketCnpj;
    }
}
