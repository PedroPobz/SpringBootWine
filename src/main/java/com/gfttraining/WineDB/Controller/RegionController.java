package com.gfttraining.WineDB.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.WineDB.Model.Region;
import com.gfttraining.WineDB.Model.Wine;
import com.gfttraining.WineDB.Model.Winery;
import com.gfttraining.WineDB.Repository.*;


@RestController
@RequestMapping("/api/region")
public class RegionController {
    
    @Autowired
    RegionRepository regionRepository;

    @GetMapping("findAll")
    public List<Region> findAll(){
        return regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Region findById(@PathVariable int id){
        return regionRepository.findById(id).get();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createRegion(@RequestBody Region region){
        regionRepository.save(region);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRegion(@PathVariable int id){
        regionRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateRegion(@PathVariable int id, @RequestBody Region region){
        Optional<Region> reg = regionRepository.findById(id);
        if(region.getName() == null || region.getName().isEmpty()){
            region.setName(reg.get().getName());
        }
        if(region.getCountry() == null || region.getCountry().isEmpty()){
            region.setCountry(reg.get().getCountry());
        }
        
   

        region.setId(id);
        regionRepository.save(region);
    }
    
}