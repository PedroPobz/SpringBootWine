package com.gfttraining.WineDB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.WineDB.Model.Winery;
import com.gfttraining.WineDB.Repository.*;

@RestController

public class WineryController {
    
    @Autowired
    WineryRepository wineryRepository;

    @GetMapping("/wineries")
    public List<Winery> getAll(){
        return wineryRepository.findAll();
    }
    
}
