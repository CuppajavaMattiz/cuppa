package com.mattiz.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionBean getCurrencyConnversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal amount) {
		Map<String, String> urlVariables = new HashMap();
		urlVariables.put("from", from);
		urlVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity(
				"http://localhost:8080/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				urlVariables);
		CurrencyConversionBean currencyConversionBean = response.getBody();
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getExchangeValue(), amount,
				currencyConversionBean.getExchangeValue().multiply(amount), currencyConversionBean.getPort());

		}
	/*does not work*/
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionBean getCurrencyConnversionFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("amount") BigDecimal amount) {
		CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeValue(from, to);
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getExchangeValue(), amount,
				currencyConversionBean.getExchangeValue().multiply(amount), currencyConversionBean.getPort());
	}
}
