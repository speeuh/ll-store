package com.ll.store.repository.entity.market;

import com.ll.store.service.dto.market.MarketResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


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
    private String workingTime;
    private String marketCnpj;


    public Market(String marketName, String marketAddress, String marketNumber, String workingTime, String marketCnpj) {
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
