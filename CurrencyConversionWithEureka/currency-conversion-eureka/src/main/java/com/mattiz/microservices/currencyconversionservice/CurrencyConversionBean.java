package com.mattiz.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long Id;
	private String from;
	private String to;
	private BigDecimal exchangeValue;
	private BigDecimal amount;
	private BigDecimal calculatedAmount;
	private int port;
	
	public CurrencyConversionBean() {
	}
	
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal exchangeValue, BigDecimal amount,
			BigDecimal calculatedAmount, int port) {
		super();
		Id = id;
		this.from = from;
		this.to = to;
		this.exchangeValue = exchangeValue;
		this.amount = amount;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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

	public BigDecimal getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(BigDecimal exchangeValue) {
		this.exchangeValue = exchangeValue;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
}
