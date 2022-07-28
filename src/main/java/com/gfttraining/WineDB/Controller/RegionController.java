package com.gfttraining.WineDB.Controller;

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
import com.gfttraining.WineDB.Service.RegionService;

@RestController
@RequestMapping("/api/region")
public class RegionController {
    
    @Autowired
    RegionService regionService;

    @GetMapping("/{id}")
    public Region findById(@PathVariable int id){
        return regionService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Region createRegion(@RequestBody Region region){
        regionService.createRegion(region);
        return region;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRegion(@PathVariable int id){
        regionService.deleteRegion(id);
    }

    @PutMapping("{id}")
    public Region updateRegion(@PathVariable int id, @RequestBody Region region){
        Region reg = regionService.findById(id);
        if(region.getName() == null || region.getName().isEmpty()){
            region.setName(reg.getName());
        }
        if(region.getCountry() == null || region.getCountry().isEmpty()){
            region.setCountry(reg.getCountry());
        }

        region.setId(id);
        regionService.createRegion(region);
        
        return region;
    }
    
}