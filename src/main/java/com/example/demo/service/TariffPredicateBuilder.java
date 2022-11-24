package com.example.demo.service;

import com.example.demo.model.QTariff;
import com.example.demo.model.query.CustomSearchQuery;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TariffPredicateBuilder {

    public Predicate getPredicates(CustomSearchQuery query) {
        QTariff tariff = QTariff.tariff;
        BooleanBuilder conditions = new BooleanBuilder();
        Optional.ofNullable(query.getDate()).map(tariff.endDate::after).ifPresent(conditions::and);
        Optional.ofNullable(query.getDate()).map(tariff.startDate::before).ifPresent(conditions::and);
        Optional.ofNullable(query.getProductId()).map(tariff.productId::eq).ifPresent(conditions::and);
        Optional.ofNullable(query.getBrandId()).map(tariff.brandId::eq).ifPresent(conditions::and);
        return conditions;
    }
}
