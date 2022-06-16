package com.ll.store.service.dto.market;

import com.ll.store.model.market.MarketResponseModel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MarketResponseDto {

    private long id;
    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private String workingTime;
    private String marketCnpj;

    public MarketResponseDto(long id, String marketName, String marketAddress, String marketNumber, String workingTime, String marketCnpj) {
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
