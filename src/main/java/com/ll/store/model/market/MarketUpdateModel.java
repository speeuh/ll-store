package com.ll.store.model.market;

import com.ll.store.service.dto.market.MarketUpdateDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketUpdateModel {

    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private String workingTime;
    private String marketCnpj;

    public MarketUpdateDto convertUpdateModelToDto() {
        return new MarketUpdateDto(marketName, marketAddress, marketNumber, workingTime, marketCnpj);
    }
}
