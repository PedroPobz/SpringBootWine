package com.gfttraining.WineDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfttraining.WineDB.Model.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer>{
    
}
