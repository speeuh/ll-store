package com.ll.store.service.dto.market;

import com.ll.store.repository.entity.market.Market;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketRequestDto {

    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private String workingTime;
    private String marketCnpj;

    public MarketRequestDto(String marketName, String marketAddress, String marketNumber,  String workingTime, String marketCnpj) {
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
