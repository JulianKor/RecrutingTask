package com.example.demo.repository;

import com.example.demo.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TariffRepository extends JpaRepository<Tariff, Long>, QuerydslPredicateExecutor<Tariff> {
}
