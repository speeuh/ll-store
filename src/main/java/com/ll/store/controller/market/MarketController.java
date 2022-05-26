package com.ll.store.controller.market;


import com.ll.store.model.market.MarketRequestModel;
import com.ll.store.model.market.MarketResponseModel;
import com.ll.store.service.dto.market.MarketRequestDto;
import com.ll.store.service.dto.market.MarketResponseDto;
import com.ll.store.service.market.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/markets")
public class MarketController {

    @Autowired
    public MarketService marketService;

    @PostMapping
    public ResponseEntity<MarketResponseModel> createMarket(@RequestBody @Valid MarketRequestModel marketRequestModel) {
        MarketRequestDto marketRequestDto = marketRequestModel.convertModelToDto();
        MarketResponseDto marketResponseDto = marketService.createMarket(marketRequestDto);
        MarketResponseModel marketResponseModel = marketResponseDto.convertResponseDtoTtoResponseModel();

        return ResponseEntity.status(HttpStatus.CREATED).body(marketResponseModel);
    }
}
