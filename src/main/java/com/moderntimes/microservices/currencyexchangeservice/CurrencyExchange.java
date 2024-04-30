package com.moderntimes.microservices.currencyexchangeservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {
    @Id
    private Long id;
    @Column(name="base_ccy")
    private String from;

    @Column(name="term_ccy")
    private String to;

    @Column(name="exchange_rate")
    private BigDecimal exchangeRate;
    private String environment;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Long id, String from, String to, BigDecimal exchangeRate) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.exchangeRate = exchangeRate;
    }

    public CurrencyExchange(Long id, String from, String to, BigDecimal exchangeRate, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.exchangeRate = exchangeRate;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", environment='" + environment + '\'' +
                '}';
    }
}
