package com.gfttraining.WineDB.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfttraining.WineDB.Model.Winery;
import com.gfttraining.WineDB.Repository.WineryRepository;

public class WineryService {
    
    @Autowired 
    WineryRepository wineryRepository;

    public Winery findById(int id){
        return wineryRepository.findById(id).get();
    }

    public Winery createWinery(Winery winery){
        return wineryRepository.save(winery);
     }
 
     public void deleteWinery(int id){
         wineryRepository.deleteById(id);
     }
}
