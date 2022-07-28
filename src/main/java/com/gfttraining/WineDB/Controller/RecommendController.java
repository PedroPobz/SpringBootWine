package com.gfttraining.WineDB.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/expensive")
	public ResponseEntity<List<Wine>> findMostExpensive(@RequestParam("top")int top){
		
		Pageable limit = PageRequest.of(0, top);
		List<Wine> list = wineService.mostExpensiveWines(limit);
		return list.size() == 0
				? ResponseEntity.noContent().build()
				: ResponseEntity.ok().body(list);
		}
	
	@GetMapping("/vintage")
	public ResponseEntity<HashMap<String, List<Wine>>> findMostVintage(@RequestParam("top")int top){
				
		Pageable limit = PageRequest.of(0, top);
		HashMap<String,List<Wine>> end = wineService.getVintageList(limit);
		return end.size() == 0
				? ResponseEntity.noContent().build()
				: ResponseEntity.ok().body(end);
	}
	
	
}