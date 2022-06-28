package com.ll.store.service.market;

import com.ll.store.config.validation.exceptions.MarketNotFoundException;
import com.ll.store.repository.entity.market.Market;
import com.ll.store.repository.market.MarketRepository;
import com.ll.store.service.dto.market.MarketRequestDto;
import com.ll.store.service.dto.market.MarketResponseDto;
import com.ll.store.service.dto.market.MarketUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<MarketResponseDto> getAllMarkets(Pageable pageable) {
        return marketRepository.findAll(pageable).map(Market::convertEntityToResponse);
    }

    public MarketResponseDto getMarketById(String id) {
        Market market = marketRepository.findById(id).orElseThrow(()-> new MarketNotFoundException("Not found market with id " + id));
        return market.convertEntityToResponse();
    }

    public void deleteMarket(String id) {

        try{
            marketRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new MarketNotFoundException(("Not found market with id " + id));
        }
    }

    public MarketResponseDto updateMarketById(MarketUpdateDto marketUpdateDto, String id) {
        Market market = marketRepository.findById(id).orElseThrow(()-> new MarketNotFoundException("Not found Market with id " + id));

        if(marketUpdateDto.getName() != null) {
            market.setName(marketUpdateDto.getName());
        }

        if(marketUpdateDto.getAddress() != null) {
            market.setAddress(marketUpdateDto.getAddress());
        }

        if(marketUpdateDto.getNumber() != null) {
            market.setNumber(marketUpdateDto.getNumber());
        }

        if(marketUpdateDto.getWorkingTime() != null) {
            market.setWorkingTime(marketUpdateDto.getWorkingTime());
        }

        if(marketUpdateDto.getCnpj() != null) {
            market.setCnpj(marketUpdateDto.getCnpj());
        }

        Market marketResponse = marketRepository.save(market);
        return marketResponse.convertEntityToResponse();
    }
}
