package com.restapi.demo.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.demo.exception.FlightException;
import com.restapi.demo.exception.FlightNotAvailable;
import com.restapi.demo.model.ConnectionFlight;
import com.restapi.demo.model.Flight;
import com.restapi.demo.model.Flightfare;
import com.restapi.demo.model.FltFare;
import com.restapi.demo.model.FltSchedule;
import com.restapi.demo.model.FltSeat;
import com.restapi.demo.repository.FlightFareRepository;
import com.restapi.demo.repository.FlightRepository;
import com.restapi.demo.repository.FltFareRepo;
import com.restapi.demo.repository.FltScheduleRepo;
import com.restapi.demo.repository.FltSeatRepo;
import com.restapi.demo.service.FlightService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class flightController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
    FlightRepository flightReposittory;
	
	@Autowired
    FlightFareRepository flightfareRepository;
	
	@Autowired
	FltScheduleRepo fltScheduleRepo;
	
	@Autowired
	FltFareRepo fltFareRepo;
	@Autowired
	FltSeatRepo fltSeatRepo;
	
	private static final Logger logger = LogManager.getLogger(flightController.class);
	
	@PostMapping("/flight")
	public ResponseEntity<?> addFlightDetails(@RequestBody List<Flight> flight) 
	{
		logger.info("Create Filght details", "Method statred");
		System.out.println(flight.toString());
		
		/*  Optional<Flight> addedflight= Optional.of(flightService.saveFlight(flight));
		  if(!addedflight.isPresent())
			throw new FlightException();
		  else
			  return new ResponseEntity<>(addedflight,HttpStatus.OK);*/
		try {
			List<Flight> addedflight= flightService.saveFlight(flight);
		 // if(addedflight == null)
			//throw new FlightException();
		 // else
			  return new ResponseEntity<>(addedflight,HttpStatus.OK);}
		catch(Exception e)
		{
			throw new FlightException();
		}
		
	}
	
	@GetMapping("/flights")
	public List<Flight> getAllFlightDetails()
	{
		logger.info("Get All Filghts", "Method statred");
		return flightService.getAllFlight();
	}
	
	@PostMapping("/search")
	public ResponseEntity<Object> getSearchFlightDetails(@RequestBody Flight flight) throws FlightNotAvailable
	{
		logger.info("Search Filghts", flight.toString());
		List<Flight> directFlight= flightReposittory.findAll().stream().filter(f -> f.getDepartureAirport().equals(flight.getDepartureAirport()) && f.getArrivalAirport().equals(flight.getArrivalAirport())).collect(Collectors.toList());// flightReposittory.searchFlightDetails(flight.getDepartureAirport(),flight.getArrivalAirport());
	    if(directFlight.size()==0)
	    {
		
		List<ConnectionFlight> connFlightMod= new ArrayList<ConnectionFlight>();
	    	List<Object> connFlight=  flightReposittory.searchStoppageFlightDetails(flight.getDepartureAirport(),flight.getArrivalAirport());
	         for(int i=0;i<connFlight.size();i++)
	        {
	        	Object[] obj=   (Object[]) connFlight.get(i);
	        	for(int j=0;j<obj.length;j++)
	        	{
	        	//	System.out.println(obj[j]);
	        	}
	        	ConnectionFlight conobj = new ConnectionFlight(obj[0].toString(),obj[1].toString(),obj[2].toString(),(Time)obj[3], obj[4].toString(),(Time)obj[5],obj[6].toString(),obj[7].toString(),obj[8].toString(),(Time)obj[9],obj[10].toString(),(Time)obj[11],(int)obj[12]);
	      
	        	
	        	
	        	connFlightMod.add(conobj);
	        }
	    	 
	       if(connFlightMod.size() == 0)
	       {
	    	   throw new FlightNotAvailable("Flight not available from "+ flight.getDepartureAirport() +" to "+ flight.getArrivalAirport());
	       }
	         
	       else 
	    	return  new  ResponseEntity<>(connFlightMod,HttpStatus.OK);
	    }
	    else
	    {
	    	  if(directFlight.size() == 0)
		       {
		    	   throw new FlightNotAvailable("Flight not available from "+ flight.getDepartureAirport() +" to "+ flight.getArrivalAirport());
		       }
		         
		       else 
		    	return  new  ResponseEntity<>(directFlight,HttpStatus.OK);
	    }
	  
	}
	
	
	/*@PostMapping("/searchflight")
	public ResponseEntity<?> searchFlights(@RequestBody Flight flight)
	{
		List<Flight> directFlight= flightReposittory.findAll().stream().filter(f -> f.getDepartureAirport().equals(flight.getDepartureAirport()) && f.getArrivalAirport().equals(flight.getArrivalAirport())).collect(Collectors.toList());// flightReposittory.searchFlightDetails(flight.getDepartureAirport(),flight.getArrivalAirport());
    	List<ConnectionFlight> connFlight=  flightReposittory.searchStoppageFlightDetails(flight.getDepartureAirport(),flight.getArrivalAirport());

		return new  ResponseEntity<>(connFlight,HttpStatus.OK);
	}*/
	
	@PostMapping("/flightwithfare")
	public ResponseEntity<?> addFlightwithFareDetails(@RequestBody Flightfare flight)
	{
		flightfareRepository.save(flight);
		
		return new ResponseEntity<>(flight, HttpStatus.OK);
	}
	
	@PostMapping("/flightwithfareupdate")
	public ResponseEntity<?> updateFlightwithFareDetails(@RequestBody List<Flightfare> listflight)
	{
		for (Flightfare flight : listflight) {
			flightfareRepository.updateFare(flight.getFareAmount(), flight.getFlightNo());
			}
		
		return new ResponseEntity<>(listflight, HttpStatus.OK);
	}
	
	
	@PostMapping("/flightsearch")
	public ResponseEntity<?> flightsearch(@RequestBody Map<String,Object> flight)
	{
		String from = flight.get("from").toString();
		String to = flight.get("to").toString();
		String travelDate = flight.get("travelDate").toString();
		String journeyType = flight.get("journeyType").toString();
		String returnDate = flight.get("returnDate").toString();
		ObjectMapper oMapper = new ObjectMapper();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		double totalFare = 0.0;
		List<FltSchedule> fltSchedule= fltScheduleRepo.findAll().stream().filter(f -> f.getDepAirport().equals(from) && f.getArrAirport().equals(to) && f.getFltDate().toString().equals(travelDate)).collect(Collectors.toList());
		for(FltSchedule flt : fltSchedule)
		{
        Map<String, Object> map = oMapper.convertValue(flt, Map.class);
        map.put("fltDate", flt.getFltDate());
        Optional<FltFare> fltFare = fltFareRepo.findAll().stream().filter( f -> f.getFltNo().equals(flt.getFltNo()) && f.getFltDate().toString().equals(flt.getFltDate().toString())).findAny();
		if(fltFare.isPresent())
		{
			map.put("fare", fltFare.get().getFltAmount());
			list.add(map);
			totalFare += fltFare.get().getFltAmount();
		}
		}
		
		Map<String, Object> inbound = new HashMap<String, Object>();
		inbound.put("outboundFlights", list);
		list = new ArrayList<Map<String, Object>>();
		if(journeyType.equalsIgnoreCase("single"))
		{
		
		return	new ResponseEntity<>(inbound,HttpStatus.OK);
		}else {
		
			fltSchedule= fltScheduleRepo.findAll().stream().filter(f -> f.getDepAirport().equals(to) && f.getArrAirport().equals(from) && f.getFltDate().toString().equals(returnDate)).collect(Collectors.toList());
			for(FltSchedule flt : fltSchedule)
			{
	        Map<String, Object> map = oMapper.convertValue(flt, Map.class);
	        map.put("fltDate", flt.getFltDate());
	       Optional<FltFare> fltFare = fltFareRepo.findAll().stream().filter( f -> f.getFltNo().equals(flt.getFltNo()) && f.getFltDate().toString().equals(flt.getFltDate().toString())).findAny();
			if(fltFare.isPresent())
			{
				map.put("fare", fltFare.get().getFltAmount());
				list.add(map);
				totalFare += fltFare.get().getFltAmount();
				inbound.put("returnFlights", list);
				inbound.put("totalFare", totalFare);
				inbound.put("currency", fltFare.get().getFltCurrency());
			}
			}
			
			
		
		return new ResponseEntity<>(inbound,HttpStatus.OK);
		}
	}
	
	
	
	

}
