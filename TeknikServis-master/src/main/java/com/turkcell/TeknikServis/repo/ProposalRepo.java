package com.turkcell.TeknikServis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TeknikServis.model.Proposal;

@Repository
public interface ProposalRepo extends JpaRepository<Proposal, Long>{

	List<Proposal> findAllByisApproved(boolean isApproved);
	List<Proposal> findAllByuserID(Long id);
}
