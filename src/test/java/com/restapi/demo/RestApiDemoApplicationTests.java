package com.restapi.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restapi.demo.model.Flight;
import com.restapi.demo.model.Flightfare;
import com.restapi.demo.repository.FlightFareRepository;
import com.restapi.demo.repository.FlightRepository;



@SpringBootTest
class RestApiDemoApplicationTests {

	@Autowired
	FlightFareRepository flightfareRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	DateFormat formatter ;
	@BeforeEach
	void setup()
	{
		formatter = new SimpleDateFormat("HH:mm:ss");
	}
	
/*	@Test
	void addFightFareTest() throws ParseException {
		
		Flightfare f1 = new Flightfare(new Date(),"A1","BOM","JFK", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()),12000);
		flightfareRepository.save(f1);
        Assertions.assertThat(f1.getId()).isGreaterThan(0);
	}
	
	@Test
	void addFightTest() throws ParseException {
		
		Flight f1 = new Flight(new Date(),"A1","BOM","JFK", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()));
		flightRepository.save(f1);
        Assertions.assertThat(f1.getFlightNo()).isEqualTo("A2");
	}
	
	@Test
	  public void searchFlightDetails() throws Exception 
		{
			
			
			Flight f1 = new Flight(new Date(),"A1","BOM","DXB", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()));
			List<Flight> flight =  flightRepository.searchFlightDetails(f1.getDepartureAirport(), f1.getArrivalAirport());
	        System.out.println(flight.size() +" serach count");
			Assertions.assertThat(flight.size()).isGreaterThan(0);
		                  
		}
	
	@Test
	  public void searchConnectedFlightDetails() throws Exception 
		{
			
			
			Flight f1 = new Flight(new Date(),"A1","BOM","JFK", new java.sql.Time(formatter.parse("12:00:00").getTime()),new java.sql.Time(formatter.parse("14:00:00").getTime()));
			List<Flight> flight =  flightRepository.searchFlightDetails(f1.getDepartureAirport(), f1.getArrivalAirport());
	        System.out.println(flight.size() +" serach count");
			Assertions.assertThat(flight.size()).isGreaterThan(0);
		                  
		}*/

}
