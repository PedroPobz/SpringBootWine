package com.gfttraining.WineDB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfttraining.WineDB.Model.Region;
import com.gfttraining.WineDB.Repository.RegionRepository;

@Service
public class RegionService {
    @Autowired
    RegionRepository regionRepository;

    public Region findById(int id){
        return regionRepository.findById(id).get();
    }

    public Region createRegion(Region region){
       return regionRepository.save(region);
    }

    public void deleteRegion(int id){
        regionRepository.deleteById(id);
    }
}
