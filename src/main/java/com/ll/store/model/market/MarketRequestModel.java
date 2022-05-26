package com.ll.store.model.market;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ll.store.service.dto.market.MarketRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class MarketRequestModel {

    @NotBlank @NotNull
    private String marketName;
    @NotNull @NotBlank
    private String marketAddress;
    @NotNull @NotBlank
    private String marketNumber;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date workingTime;
    @NotNull
    private long marketCnpj;

    public MarketRequestDto convertModelToDto() {
        return new MarketRequestDto(marketName, marketAddress, marketNumber, workingTime, marketCnpj);
    }
}
