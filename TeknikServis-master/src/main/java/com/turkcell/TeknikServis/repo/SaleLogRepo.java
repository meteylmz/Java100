package com.turkcell.TeknikServis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TeknikServis.model.SaleLOG;

@Repository
public interface SaleLogRepo extends JpaRepository<SaleLOG, Long>
{
}