package com.ll.store.service.market;

import com.ll.store.repository.entity.market.Market;
import com.ll.store.repository.market.MarketRepository;
import com.ll.store.service.dto.market.MarketRequestDto;
import com.ll.store.service.dto.market.MarketResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    public MarketResponseDto createMarket(MarketRequestDto marketRequestDto) {

        Market market = marketRequestDto.convertDtoToEntity();
        Market marketResponse = marketRepository.save(market);

        return marketResponse.convertEntityToResponse();
    }
}
