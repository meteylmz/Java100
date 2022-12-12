package com.turkcell.TeknikServis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.model.Proposal;
import com.turkcell.TeknikServis.repo.ProposalRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProposalService {

	private ProposalRepo proposalRepo;
	
	public Proposal createProposal(Proposal proposal) {
		return proposalRepo.save(proposal);
	}
	
	public Proposal getById(Long id) {
		return proposalRepo.findById(id).get();
	}
	
	public void deleteById(Long id) {
		proposalRepo.deleteById(id);
	}
	
	public List<Proposal> getAll(){
		return proposalRepo.findAll();
	}
	
	public Proposal editStatus(Long id, boolean status) {
		proposalRepo.findById(id).get().setApproved(status);
		proposalRepo.save(proposalRepo.findById(id).get());
		return proposalRepo.findById(id).get();
	}
	
	public List<Proposal> getAllByUser(Long userid){
		return proposalRepo.findAllByuserID(userid);
	}
	
	public List<Proposal> getAllStatus(boolean isApproved)
	{
		return proposalRepo.findAllByisApproved(isApproved);
	}
}
