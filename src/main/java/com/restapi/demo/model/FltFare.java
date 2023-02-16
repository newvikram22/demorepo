package com.restapi.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FltFare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fltNo;
	private Date fltDate;
	private String fltCurrency;
	private double fltAmount;
	
	
	
	public FltFare() {
		super();
	}
	public FltFare(String fltNo, Date fltDate, String fltCurrency, double fltAmount) {
		super();
		this.fltNo = fltNo;
		this.fltDate = fltDate;
		this.fltCurrency = fltCurrency;
		this.fltAmount = fltAmount;
	}
	public String getFltNo() {
		return fltNo;
	}
	public void setFltNo(String fltNo) {
		this.fltNo = fltNo;
	}
	public Date getFltDate() {
		return fltDate;
	}
	public void setFltDate(Date fltDate) {
		this.fltDate = fltDate;
	}
	public String getFltCurrency() {
		return fltCurrency;
	}
	public void setFltCurrency(String fltCurrency) {
		this.fltCurrency = fltCurrency;
	}
	public double getFltAmount() {
		return fltAmount;
	}
	public void setFltAmount(double fltAmount) {
		this.fltAmount = fltAmount;
	}
	
	
	

}
