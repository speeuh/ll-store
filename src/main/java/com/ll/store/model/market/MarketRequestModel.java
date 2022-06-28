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
    private String name;
    @NotNull @NotBlank
    private String address;
    @NotNull @NotBlank
    private String number;
    @NotNull
    private String workingTime;
    @NotNull
    private String cnpj;

    public MarketRequestDto convertModelToDto() {
        return new MarketRequestDto(name, address, number, workingTime, cnpj);
    }
}
