package com.moderntimes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo(String from, String to);
    List<CurrencyExchange> findByTo(String to);
    List<CurrencyExchange> findByFrom(String from);

}
