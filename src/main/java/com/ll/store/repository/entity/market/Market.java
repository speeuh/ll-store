package com.ll.store.repository.entity.market;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ll.store.service.dto.market.MarketResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "markets")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String marketName;
    private String marketAddress;
    private String marketNumber;
    private Date workingTime;
    private long marketCnpj;


    public Market(String marketName, String marketAddress, String marketNumber, Date workingTime, long marketCnpj) {
        this.marketName = marketName;
        this.marketAddress = marketAddress;
        this.marketNumber = marketNumber;
        this.workingTime = workingTime;
        this.marketCnpj = marketCnpj;
    }

    public Market() {
    }

    public MarketResponseDto convertEntityToResponse(){
        return new MarketResponseDto(id, marketName, marketAddress, marketNumber, workingTime, marketCnpj);
    }
}
