package com.ll.store.repository.entity.market;

import com.ll.store.service.dto.market.MarketResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "markets")
public class Market {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String address;
    private String number;
    private String workingTime;
    private String cnpj;


    public Market(String name, String address, String number, String workingTime, String cnpj) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.workingTime = workingTime;
        this.cnpj = cnpj;
    }

    public Market() {
    }

    public MarketResponseDto convertEntityToResponse(){
        return new MarketResponseDto(id, name, address, number, workingTime, cnpj);
    }
}
