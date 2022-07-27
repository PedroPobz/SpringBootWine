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
import com.gfttraining.WineDB.Service.WineService;


@RestController
@RequestMapping("/api/wine")
public class WineController {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    Date date = new Date ();
    int thisYear = Integer.parseInt(formatter.format(date));
    
    @Autowired
    WineService wineService;

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
        wineValidation(wine);
      return  wineService.createWine(wine);
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

    private void wineValidation(Wine wine) throws Exception{
        if(wine.getName() == null || wine.getName().trim().isEmpty()){
            throw new Exception("No name of wine");
        }
        if(wine.getYear() < 1900 || wine.getYear() > thisYear){
            throw new Exception("Bad year");
        }
        if(wine.getRating() < 0 || wine.getRating() > 5){
            throw new Exception("Bad rating");
        }
        if(wine.getBody() < 1 || wine.getBody() > 5){
            throw new Exception("Bad body");
        }
        if(wine.getAcidity() < 1 || wine.getAcidity() > 5){
            throw new Exception("Bad acidity");
        }
        if(wine.getNum_reviews() < 0){
            throw new Exception("Bad number of reviews");
        }
        if(wine.getPrice() < 0){
            throw new Exception("Bad price");
        }
    }
    
}