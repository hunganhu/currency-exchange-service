package com.moderntimes.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {

//        CurrencyExchange currencyExchange =
//                new CurrencyExchange(1004l, from, to, BigDecimal.valueOf(50l));
        CurrencyExchange currencyExchange
                = repository.findByFromAndTo(from, to);

        if (currencyExchange == null) {
            throw new RuntimeException
                    ("Unable to Find data for " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");

        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }

    @GetMapping("/currency-exchange/to/{to}")
    public List<CurrencyExchange> retrieveExchangeToList(
            @PathVariable String to) {

        List<CurrencyExchange> currencyExchangeList
                = repository.findByTo(to);

        if (currencyExchangeList == null) {
            throw new RuntimeException
                    ("Unable to Find data for " + to);
        }

        String port = environment.getProperty("local.server.port");

        // 将 lambda 表达式传递给 forEach
        for (CurrencyExchange e : currencyExchangeList) {
            e.setEnvironment(port);
        }

        //currencyExchange.setEnvironment(port);

        return currencyExchangeList;
    }

    @GetMapping("/currency-exchange/from/{from}")
    public List<CurrencyExchange> retrieveExchangeFromList(
            @PathVariable String from) {

        List<CurrencyExchange> currencyExchangeList
                = repository.findByFrom(from);

        if (currencyExchangeList == null) {
            throw new RuntimeException
                    ("Unable to Find data for " + from);
        }

        String port = environment.getProperty("local.server.port");

        // 将 lambda 表达式传递给 forEach
        for (CurrencyExchange e : currencyExchangeList) {
            e.setEnvironment(port);
        }

        return currencyExchangeList;
    }

}