package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Branch;
import com.example.demo.repository.BranchRepository;


@RestController
public class BranchController {
	
	@Autowired
	private BranchRepository br;
	
	@PostMapping("/branch")
	public Branch create(@RequestBody Branch branch ) 
	{
		return br.save(branch);
	}
	
	@GetMapping("/branch")
	public List<Branch> read() 
	{
		return br.findAll();
	}
	
	@GetMapping("/branch/{bid}")
	public Branch read(@PathVariable("bid") String bid)
	{
		return br.findById(bid).get();
	}
	
	@PutMapping("/branch")
	public Branch update(@RequestBody Branch branch) 
	{
		return br.save(branch);
	}
	
	@DeleteMapping("/branch")
	public Branch delete(@RequestBody Branch branch) 
	{
		return br.save(branch);
	}
	
	
	
	

}
