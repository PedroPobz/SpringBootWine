package com.gfttraining.WineDB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    public Wine createWine(Wine wine){
       return wineRepository.save(wine);
    }

    public void deleteWine(int id){
        wineRepository.deleteById(id);
    }
    
    public List<Wine> bestRating(Pageable limit){
    	return wineRepository.findAllOrderByRatingDesc(limit);
    }
    
    public List<Wine> mostExpensiveWines(Pageable limit){
    	return wineRepository.findAllOrderByPriceDesc(limit);
    }
    
    public List<Wine> bestBangBuckWines(Pageable limit){
    	return wineRepository.findBestBanForTheBuck(limit);
    }
    
    public List<String> bestYearsOfWine(Pageable limit){ 
    	return wineRepository.findYearsWithBestRatedWine(limit);
    	}
}
