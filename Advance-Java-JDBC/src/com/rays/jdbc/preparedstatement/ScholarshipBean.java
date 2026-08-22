package com.rays.jdbc.preparedstatement;

import java.util.Date;

public class ScholarshipBean {
	
	private int scholarshipId;
	private String scholarshipName ;
	private int amount;
	private String eligibility;
	private Date lastdate;
	
	public int getScholarshipId() {
		return scholarshipId;
	}
	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}
	public String getScholarshipName() {
		return scholarshipName;
	}
	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	
	

}
 