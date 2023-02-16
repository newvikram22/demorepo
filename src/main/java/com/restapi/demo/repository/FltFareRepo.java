package com.restapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.restapi.demo.model.FltFare;
public interface FltFareRepo extends JpaRepository<FltFare,Long>{

}
