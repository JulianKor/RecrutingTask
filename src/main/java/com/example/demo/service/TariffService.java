package com.example.demo.service;

import com.example.demo.model.Tariff;
import com.example.demo.model.query.CustomSearchQuery;
import com.example.demo.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static org.springframework.data.domain.PageRequest.of;

@Service
@Slf4j
@RequiredArgsConstructor
public class TariffService {

    private final TariffPredicateBuilder tariffPredicateBuilder;
    private final TariffRepository tariffRepository;

    public List<Tariff> findByCustomCriteria(CustomSearchQuery customSearchQuery) {
        log.debug("findByCustomCriteria({})", customSearchQuery);
        return tariffRepository.findAll(tariffPredicateBuilder.getPredicates(customSearchQuery), of(0, MAX_VALUE)).getContent();
    }
}
