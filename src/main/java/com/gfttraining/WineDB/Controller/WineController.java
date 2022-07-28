package com.gfttraining.WineDB.Controller;



import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.gfttraining.WineDB.Repository.RegionRepository;
import com.gfttraining.WineDB.Repository.TypeRepository;
import com.gfttraining.WineDB.Repository.WineryRepository;
import com.gfttraining.WineDB.Service.WineService;


@RestController
@RequestMapping("/api/wine")
public class WineController {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    Date date = new Date ();
    int thisYear = Integer.parseInt(formatter.format(date));
    
    @Autowired
    WineService wineService;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    WineryRepository wineryRepository;

    @Autowired
    RegionRepository regionRepository;

    WineController(WineService wineService) {
        this.wineService = wineService;
    }


    @GetMapping("/{id}")
    public Wine findById(@PathVariable int id){
        return wineService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Wine createWine(@RequestBody Wine wine) throws Exception{
        /* wineValidation(wine); */
      return  wineService.createWine(wine);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWine(@PathVariable int id){
        wineService.deleteWine(id);
    }

    @PutMapping("{id}")
    public void updateWwine(@PathVariable int id, @RequestBody Wine wine) throws Exception{
        Wine win = wineService.findById(id);
        if(wine.getName() == null || wine.getName().isEmpty()){
            wine.setName(win.getName());
        }
        if(wine.getYear() == "0"){
            wine.setYear(win.getYear());
        }

        wine.setId(id);
        wineService.createWine(wine);
    }

    
}