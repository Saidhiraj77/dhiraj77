package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Branch {

	
	private String bname;
	private String bcity;
	@Id
	private String bid;

	public Branch() {
	}

	public Branch(String bnmae, String bcity, String bid) {
		super();
		this.bname = bname;
		this.bcity = bcity;
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBcity() {
		return bcity;
	}

	public void setBcity(String bcity) {
		this.bcity = bcity;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Branch [bnmae=" + bname + ", bcity=" + bcity + ", bid=" + bid + "]";
	}

	
}
