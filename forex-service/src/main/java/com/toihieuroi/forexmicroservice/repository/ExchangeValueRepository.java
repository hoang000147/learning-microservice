package com.toihieuroi.forexmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toihieuroi.forexmicroservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
