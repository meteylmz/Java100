package com.turkcell.TeknikServis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TeknikServis.model.Service;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long>
{

}
