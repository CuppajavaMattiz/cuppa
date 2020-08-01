package com.mattiz.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MattizJpaRespository extends JpaRepository<ExchangeValue, Long>{

	ExchangeValue findByFromAndTo(String from, String to);
}
