package com.ll.store.model.market;

import com.ll.store.service.dto.market.MarketUpdateDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketUpdateModel {

    private String name;
    private String address;
    private String number;
    private String workingTime;
    private String cnpj;

    public MarketUpdateDto convertUpdateModelToDto() {
        return new MarketUpdateDto(name, address, number, workingTime, cnpj);
    }
}
