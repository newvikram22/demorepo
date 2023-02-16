package com.restapi.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FltSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fltNo;
	private Date fltDate;
	private String depAirport;
	private String depCity;
	private String arrAirport;
	private String arrCity;
	
	
	
	public FltSchedule() {
		super();
	}
	public FltSchedule(String fltNo, Date fltDate, String depAirport, String depCity, String arrAirport,
			String arrCity) {
		super();
		this.fltNo = fltNo;
		this.fltDate = fltDate;
		this.depAirport = depAirport;
		this.depCity = depCity;
		this.arrAirport = arrAirport;
		this.arrCity = arrCity;
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
	public String getDepAirport() {
		return depAirport;
	}
	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	public String getArrAirport() {
		return arrAirport;
	}
	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}
	public String getArrCity() {
		return arrCity;
	}
	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}
	

}
