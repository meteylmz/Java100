package com.turkcell.TeknikServis.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.turkcell.TeknikServis.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long>
{
	public List<Booking> OrderByBOOKINGDATEAsc();
	public List<Booking> OrderByBOOKINGDATEDesc();
	 
	
	@Query(name = "findByBookingLikeName", value = "SELECT p FROM Booking p WHERE p.USER.NAME LIKE %:NAME%")
	public List<Booking> findByBookingLikeName(@Param("NAME")String name);
	
	List<Booking> searchByBOOKINGDATE(LocalDate bookingDate);
}