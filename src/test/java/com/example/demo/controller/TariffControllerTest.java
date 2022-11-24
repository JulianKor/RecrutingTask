package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(classes = DemoApplication.class)
class TariffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void firstTest() throws Exception {
        // given
        String responseForFirstTestCase = getResponseForFirstTestCase();

        //when
        mockMvc.perform(get("/tariff" + getSearchCriteriaForFirstCase()))
                .andExpect(status().isOk())
                .andExpect(content().json(responseForFirstTestCase));
    }

    @Test
    public void secondTest() throws Exception {
        // given
        String response = getResponseForSecondTest();

        //when
        mockMvc.perform(get("/tariff" + getSearchCriteriaForSecondCase()))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    public void thirdTest() throws Exception {
        // given
        String response = getResponseForThirdTest();

        //when
        mockMvc.perform(get("/tariff" + getSearchCriteriaForThirdCase()))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    public void fourthTest() throws Exception {
        // given
        String response = getResponseForFourthTest();

        //when
        mockMvc.perform(get("/tariff" + getSearchCriteriaForFourthCase()))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    public void fifthTest() throws Exception {
        // given
        String response = getResponseForFifthTest();

        //when
        mockMvc.perform(get("/tariff" + getSearchCriteriaForFifthCase()))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    private String getSearchCriteriaForFirstCase() {
        return "?date=2020-06-14 10:00:00&productId=35455&brandId=1";
    }

    private String getSearchCriteriaForSecondCase() {
        return "?date=2020-06-14 16:00:00&productId=35455&brandId=1";
    }

    private String getSearchCriteriaForThirdCase() {
        return "?date=2020-06-14 21:00:00&productId=35455&brandId=1";
    }

    private String getSearchCriteriaForFourthCase() {
        return "?date=2020-06-15 10:00:00&productId=35455&brandId=1";
    }

    private String getSearchCriteriaForFifthCase() {
        return "?date=2020-06-16 21:00:00&productId=35455&brandId=1";
    }

    private String getResponseForFirstTestCase() {
        return """
                [
                    {
                        "productId": 35455,
                        "brandId": 1,
                        "price": 36,
                        "startDate": "2020-06-14 00:00:00",
                        "endDate": "2020-12-31 23:59:59"
                    }
                ]""";

    }

    private String getResponseForSecondTest() {
        return """
                [
                     {
                         "productId": 35455,
                         "brandId": 1,
                         "price": 36,
                         "startDate": "2020-06-14 00:00:00",
                         "endDate": "2020-12-31 23:59:59"
                     },
                     {
                         "productId": 35455,
                         "brandId": 1,
                         "price": 25,
                         "startDate": "2020-06-14 15:00:00",
                         "endDate": "2020-06-14 18:30:00"
                     }
                 ]""";
    }

    private String getResponseForThirdTest() {
        return """
                [
                      {
                          "productId": 35455,
                          "brandId": 1,
                          "price": 36,
                          "startDate": "2020-06-14 00:00:00",
                          "endDate": "2020-12-31 23:59:59"
                      }
                  ]""";
    }

    private String getResponseForFourthTest() {
        return """
                [
                    {
                        "productId": 35455,
                        "brandId": 1,
                        "price": 36,
                        "startDate": "2020-06-14 00:00:00",
                        "endDate": "2020-12-31 23:59:59"
                    },
                    {
                        "productId": 35455,
                        "brandId": 1,
                        "price": 31,
                        "startDate": "2020-06-15 00:00:00",
                        "endDate": "2020-06-15 11:00:00"
                    }
                ]""";
    }

    private String getResponseForFifthTest() {
        return """
                [
                     {
                         "productId": 35455,
                         "brandId": 1,
                         "price": 36,
                         "startDate": "2020-06-14 00:00:00",
                         "endDate": "2020-12-31 23:59:59"
                     },
                     {
                         "productId": 35455,
                         "brandId": 1,
                         "price": 39,
                         "startDate": "2020-06-15 16:00:00",
                         "endDate": "2020-12-31 23:59:59"
                     }
                 ]""";
    }

}