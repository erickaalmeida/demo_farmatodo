package com.example.demo.repositories;

import com.example.demo.models.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<LocationModel, Long> {
}
