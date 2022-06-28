package com.ll.store.service.dto.market;

import com.ll.store.model.market.MarketResponseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
public class MarketResponseDto {

    private String id;
    private String name;
    private String address;
    private String number;
    private String workingTime;
    private String cnpj;

    public MarketResponseDto(String id, String name, String address, String number, String workingTime, String cnpj) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.workingTime = workingTime;
        this.cnpj = cnpj;
    }

    public MarketResponseModel convertResponseDtoTtoResponseModel(){
        return new MarketResponseModel(id, name, address, number, workingTime, cnpj);
    }
}
