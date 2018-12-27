package com.toihieuroi.forexmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.toihieuroi.forexmicroservice.entity.ExchangeValue;
import com.toihieuroi.forexmicroservice.repository.ExchangeValueRepository;

@RestController
public class ForexController {
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepo;
	@Autowired
	private Environment env;
	
	@GetMapping("/exchange-value/from/{from}/to/{to}")
	public ExchangeValue findExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = this.exchangeValueRepo.findByFromAndTo(from, to);
		if(exchangeValue != null) {
			exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		}
		return exchangeValue;
	}
}
