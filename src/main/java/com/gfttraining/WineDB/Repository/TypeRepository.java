package com.gfttraining.WineDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfttraining.WineDB.Model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer>{
    
}
