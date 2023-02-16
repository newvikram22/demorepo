package com.restapi.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FltSeat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fltNo;
	private Date fltrDate;
	private long avbleSeat;
	
	
	
	public FltSeat() {
		super();
	}
	public FltSeat(String fltNo, Date fltrDate, long avbleSeat) {
		super();
		this.fltNo = fltNo;
		this.fltrDate = fltrDate;
		this.avbleSeat = avbleSeat;
	}
	public String getFltNo() {
		return fltNo;
	}
	public void setFltNo(String fltNo) {
		this.fltNo = fltNo;
	}
	public Date getFltrDate() {
		return fltrDate;
	}
	public void setFltrDate(Date fltrDate) {
		this.fltrDate = fltrDate;
	}
	public long getAvbleSeat() {
		return avbleSeat;
	}
	public void setAvbleSeat(long avbleSeat) {
		this.avbleSeat = avbleSeat;
	}
	
	

}
