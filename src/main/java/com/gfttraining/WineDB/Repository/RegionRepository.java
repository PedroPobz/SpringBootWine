package com.gfttraining.WineDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfttraining.WineDB.Model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{
    
}
