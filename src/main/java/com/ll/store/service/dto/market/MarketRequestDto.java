package com.ll.store.service.dto.market;

import com.ll.store.repository.entity.market.Market;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MarketRequestDto {

    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private Date workingTime;
    private long marketCnpj;

    public MarketRequestDto(String marketName, String marketAddress, String marketNumber, Date workingTime, long marketCnpj) {
        this.marketName = marketName;
        this.marketAddress = marketAddress;
        this.marketNumber = marketNumber;
        this.workingTime = workingTime;
        this.marketCnpj = marketCnpj;
    }

    public Market convertDtoToEntity(){
        return new Market(marketName, marketAddress, marketNumber, workingTime, marketCnpj);
    }
}
