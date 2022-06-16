package com.ll.store.model.market;

import com.ll.store.service.dto.market.MarketRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MarketRequestModel {

    @NotBlank @NotNull
    private String marketName;
    @NotNull @NotBlank
    private String marketAddress;
    @NotNull @NotBlank
    private String marketNumber;
    @NotNull
    private String workingTime;
    @NotNull
    private String marketCnpj;

    public MarketRequestDto convertModelToDto() {
        return new MarketRequestDto(marketName, marketAddress, marketNumber, workingTime, marketCnpj);
    }
}
