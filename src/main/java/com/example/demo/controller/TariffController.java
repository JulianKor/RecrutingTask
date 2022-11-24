package com.example.demo.controller;

import com.example.demo.model.dto.TariffDto;
import com.example.demo.model.query.CustomSearchQuery;
import com.example.demo.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tariff")
@RequiredArgsConstructor
public class TariffController {

    private final TariffService tariffService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TariffDto>> searchByCriteria(@ModelAttribute CustomSearchQuery customSearchQuery) {
        return ResponseEntity.ok(tariffService.findByCustomCriteria(customSearchQuery)
                .stream().map(t -> modelMapper.map(t, TariffDto.class)).collect(Collectors.toList()));
    }

}
