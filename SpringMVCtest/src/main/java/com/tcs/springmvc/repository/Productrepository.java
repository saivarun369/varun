package com.tcs.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.springmvc.entity.Productentity;

public interface Productrepository extends JpaRepository<Productentity, Long>{

}
