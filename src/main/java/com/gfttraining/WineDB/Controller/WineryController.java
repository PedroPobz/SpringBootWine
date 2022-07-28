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

import com.gfttraining.WineDB.Model.Winery;
import com.gfttraining.WineDB.Service.WineryService;


@RestController
@RequestMapping("/api/winery")
public class WineryController {
    
    @Autowired
    WineryService wineryService;

    @GetMapping("/{id}")
    public Winery findById(@PathVariable int id){
        return wineryService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Winery createWinery(@RequestBody Winery winery){
       return wineryService.createWinery(winery);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWinery(@PathVariable int id){
        wineryService.deleteWinery(id);
    }

    @PutMapping("{id}")
    public Winery updateWwinery(@PathVariable int id, @RequestBody Winery winery){
        Winery win = wineryService.findById(id);
        if(winery.getName() == null || winery.getName().isEmpty()){
            winery.setName(win.getName());
        }

        winery.setId(id);
        return wineryService.createWinery(winery);
    }
    
}
