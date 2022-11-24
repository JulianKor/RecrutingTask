package com.example.demo.service;


import com.example.demo.model.Tariff;
import com.example.demo.model.query.CustomSearchQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
@ActiveProfiles("integration-tests")
class TariffServiceTest {

    @Autowired
    private TariffService service;

    @Test
    public void getTariffDtoListByGivenCriteriaHappyCase() {
        String str = "2020-06-15 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        CustomSearchQuery customSearchQuery = new CustomSearchQuery();
        customSearchQuery.setDate(dateTime);
        customSearchQuery.setProductId(35455L);
        customSearchQuery.setBrandId(1L);

        List<Tariff> result = service.findByCustomCriteria(customSearchQuery);
        Assertions.assertEquals(2, result.size());
    }
}