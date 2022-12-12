package com.turkcell.TeknikServis.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turkcell.TeknikServis.model.SaleLOG;
import com.turkcell.TeknikServis.repo.SaleLogRepo;
import com.turkcell.TeknikServis.repo.SaleRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleLogService
{
	private SaleLogRepo repo;
	private SaleRepo saleRepo;
	
	private EntityManager em;
	
	public SaleLOG create(SaleLOG log)
	{
		log = repo.save(log);
		repo.flush();
		em.clear();
		log = repo.findById(log.getId()).get();
		log.getSALE().setISSOLD(true);
		saleRepo.save(log.getSALE());
		//log = repo.findAllById(List.of(log.getId())).get(0);
		return log;
	}
}
