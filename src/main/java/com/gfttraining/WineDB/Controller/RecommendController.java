package com.gfttraining.WineDB.Controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.WineDB.Model.Region;
import com.gfttraining.WineDB.Model.Wine;
import com.gfttraining.WineDB.Repository.RegionRepository;
import com.gfttraining.WineDB.Repository.WineRepository;
import com.gfttraining.WineDB.Service.WineService;

@RestController
@RequestMapping("/api/recommend")
public class RecommendController {
	@Autowired
	RegionRepository regionRepository;
	
	@Autowired
	WineService wineService;
	
	@Autowired
	WineRepository wineRepository;
	
	@GetMapping("/best")
    public ResponseEntity<List<Wine>> findBestRate(@RequestParam("top")int top){
        Pageable limit = PageRequest.of(0, top);
        List<Wine> list = wineService.bestRating(limit);
        return list.size() == 0 
        		? ResponseEntity.noContent().build()
        		: ResponseEntity.ok().body(list);
    }

}