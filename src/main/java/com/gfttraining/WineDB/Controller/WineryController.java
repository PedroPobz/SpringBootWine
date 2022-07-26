package com.gfttraining.WineDB.Controller;


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

import com.gfttraining.WineDB.Model.Winery;
import com.gfttraining.WineDB.Repository.*;


@RestController
@RequestMapping("/api/winery")
public class WineryController {
    
    @Autowired
    WineryRepository wineryRepository;

    @GetMapping("/{id}")
    public Winery findById(@PathVariable int id){
        return wineryRepository.findById(id).get();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createWinery(@RequestBody Winery winery){
        wineryRepository.save(winery);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWinery(@PathVariable int id){
        wineryRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateWwinery(@PathVariable int id, @RequestBody Winery winery){
        Optional<Winery> win = wineryRepository.findById(id);
        if(winery.getName() == null || winery.getName().isEmpty()){
            winery.setName(win.get().getName());
        }

        winery.setId(id);
        wineryRepository.save(winery);
    }
    
}
