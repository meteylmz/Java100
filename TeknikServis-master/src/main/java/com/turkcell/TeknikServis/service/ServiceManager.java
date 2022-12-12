package com.turkcell.TeknikServis.service;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.repo.ServiceRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceManager
{
	private ServiceRepo repo;

	public com.turkcell.TeknikServis.model.Service findById(Long id)
	{
		return repo.findById(id).get();
	}
}
