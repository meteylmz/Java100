package com.turkcell.TeknikServis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.model.Sale;
import com.turkcell.TeknikServis.repo.SaleRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {
	
	private SaleRepo saleRepo;
	
	
	public Sale createSale(Sale sale) {
		
		return saleRepo.save(sale);
	}
	
	public List<Sale> getAllSale(){
		
		return saleRepo.findAllByISSOLD(false);
	}

	public void deleteById(Long id)
	{
		saleRepo.deleteById(id);
	}

	public List<Sale> getByProduct(Long id)
	{
		return saleRepo.findAllByproductIDAndISSOLD(id, false);
	}
}