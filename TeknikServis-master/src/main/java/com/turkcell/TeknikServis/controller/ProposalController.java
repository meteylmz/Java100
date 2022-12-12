package com.turkcell.TeknikServis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TeknikServis.model.Proposal;
import com.turkcell.TeknikServis.service.ProposalService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("proposal")
@AllArgsConstructor
public class ProposalController {

	private ProposalService proposalService;
	
	@PostMapping(path = "create")
	public Proposal createProposal(@RequestBody Proposal proposal) {
		return proposalService.createProposal(proposal);
	}
	
	@GetMapping(path = "getById/{id}")
	public Proposal getById(@PathVariable(name = "id") Long id) {
		return proposalService.getById(id);
	}
	
	@GetMapping(path = "getAll")
	public List<Proposal> getAll(){
		return proposalService.getAll();
	}
	
	@GetMapping(path = "getAllByUser")
	public List<Proposal> getAllByUser(@RequestBody Long id){
		return proposalService.getAllByUser(id);
	}
	
	@GetMapping(path = "getAllStatus")
	public List<Proposal> getAllStatus(@RequestBody boolean isApproved){
		return proposalService.getAllStatus(isApproved);
	}
	
	@DeleteMapping(path = "deleteById/{id}")
	public void deleteById(@PathVariable(name = "id") Long id) {
		proposalService.deleteById(id);
	}
	
	@PutMapping(path = "editStatus/{id}")
	public Proposal editStatus(@PathVariable(name = "id") Long id, @RequestBody boolean status) {
		return proposalService.editStatus(id, status);
	}
}
