package com.turkcell.TeknikServis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TeknikServis.model.Sale;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long>
{
	List<Sale> findAllByproductID(Long id);

	List<Sale> findAllByISSOLD(boolean ISSOLD);

	List<Sale> findAllByproductIDAndISSOLD(Long id, boolean ISSOLD);

}