package com.ll.store.service.dto.market;

import com.ll.store.model.market.MarketResponseModel;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;


@Getter
@Setter
public class MarketResponseDto {

    private long id;
    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private Date workingTime;
    private long marketCnpj;

    public MarketResponseDto(long id, String marketName, String marketAddress, String marketNumber, Date workingTime, long marketCnpj) {
        this.id = id;
        this.marketName = marketName;
        this.marketAddress = marketAddress;
        this.marketNumber = marketNumber;
        this.workingTime = workingTime;
        this.marketCnpj = marketCnpj;
    }

    public MarketResponseModel convertResponseDtoTtoResponseModel(){
        return new MarketResponseModel(id, marketName, marketAddress, marketNumber, workingTime, marketCnpj);
    }
}
