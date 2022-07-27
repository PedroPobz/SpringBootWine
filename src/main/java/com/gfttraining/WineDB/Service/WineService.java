package com.gfttraining.WineDB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfttraining.WineDB.Model.Wine;
import com.gfttraining.WineDB.Repository.WineRepository;

@Service
public class WineService {
    @Autowired
    WineRepository wineRepository;

    public Wine findById(int id){
        return wineRepository.findById(id).get();
    }

    public void createWine(Wine wine){
        wineRepository.save(wine);
    }

    public void deleteWine(int id){
        wineRepository.deleteById(id);
    }

}
