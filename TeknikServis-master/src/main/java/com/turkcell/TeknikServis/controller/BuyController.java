package com.turkcell.TeknikServis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TeknikServis.model.SaleLOG;
import com.turkcell.TeknikServis.service.SaleLogService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("buy")
@AllArgsConstructor
public class BuyController
{
	private SaleLogService service;

	@PostMapping("/save")
	public ResponseEntity<SaleLOG> createSale(@RequestBody SaleLOG log)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(log));
	}

}