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

import com.gfttraining.WineDB.Model.Wine;
import com.gfttraining.WineDB.Repository.*;
import com.gfttraining.WineDB.Service.WineService;


@RestController
@RequestMapping("/api/wine")
public class WineController {
    
    @Autowired
    WineService wineService;

    @GetMapping("/{id}")
    public Wine findById(@PathVariable int id){
        return wineService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createWine(@RequestBody Wine wine){
        wineService.createWine(wine);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWine(@PathVariable int id){
        wineService.deleteWine(id);
    }

    @PutMapping("{id}")
    public void updateWwine(@PathVariable int id, @RequestBody Wine wine){
        Wine win = wineService.findById(id);
        if(wine.getName() == null || wine.getName().isEmpty()){
            wine.setName(win.getName());
        }
        if(wine.getYear() == 0){
            wine.setYear(win.getYear());
        }
   

        wine.setId(id);
        wineService.createWine(wine);
    }
    
}