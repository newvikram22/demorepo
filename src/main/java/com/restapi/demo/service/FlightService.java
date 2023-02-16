package com.restapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.model.Flight;
import com.restapi.demo.repository.FlightRepository;

@Service
public class FlightService {
	
	
	@Autowired
    FlightRepository flightReposittory;
	
	
	public List<Flight> saveFlight(List<Flight> flight)
	{
		List<Flight> newflight = flightReposittory.saveAll(flight);
		return newflight;
	}
	
	public List<Flight> getAllFlight()
	{
		return flightReposittory.findAll();
	}

}
