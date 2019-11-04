package com.example.bikedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bikedemo.models.Bike;

// NOTE: ORM, between Bike class and DB, and id as primary key
public interface BikeRepository extends JpaRepository<Bike, Long> {

}
