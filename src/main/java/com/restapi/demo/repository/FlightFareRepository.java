package com.restapi.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapi.demo.model.Flightfare;

import jakarta.transaction.Transactional;

@Repository
public interface FlightFareRepository extends CrudRepository<Flightfare,Integer> {

	  @Transactional
	  @Modifying
	  @Query(value = "UPDATE flightfaretbl SET fare_amount = ?1 where flight_no= ?2 " , nativeQuery = true)
	  void updateFare(double fare, String flightno);
}
