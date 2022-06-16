package com.ll.store.controller.market;


import com.ll.store.model.market.MarketRequestModel;
import com.ll.store.model.market.MarketResponseModel;
import com.ll.store.model.market.MarketUpdateModel;
import com.ll.store.service.dto.market.MarketRequestDto;
import com.ll.store.service.dto.market.MarketResponseDto;
import com.ll.store.service.dto.market.MarketUpdateDto;
import com.ll.store.service.market.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Objects;

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

    @GetMapping
    public ResponseEntity<Page<MarketResponseModel>> getAllMarkets(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<MarketResponseDto> marketResponseDto = marketService.getAllMarkets(pageable);

        return ResponseEntity.ok(marketResponseDto.map(MarketResponseDto::convertResponseDtoTtoResponseModel));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<MarketResponseModel> getMarketById(@PathVariable long id) {
        MarketResponseDto marketResponseDto = marketService.getMarketById(id);

        return ResponseEntity.ok(marketResponseDto.convertResponseDtoTtoResponseModel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMarketById(@PathVariable long id) {
        marketService.deleteMarket(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<MarketResponseModel> updateMarketById(@PathVariable long id, @RequestBody MarketUpdateModel marketUpdateModel, BindingResult result) throws Exception {
        try {
            if (result.hasErrors()) {
                throw new IllegalArgumentException(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            }
            MarketUpdateDto marketUpdateDto = marketUpdateModel.convertUpdateModelToDto();
            MarketResponseDto marketResponseDto = marketService.updateMarketById(marketUpdateDto, id);
            MarketResponseModel marketResponseModel = marketResponseDto.convertResponseDtoTtoResponseModel();

            return new ResponseEntity<>(marketResponseModel, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
