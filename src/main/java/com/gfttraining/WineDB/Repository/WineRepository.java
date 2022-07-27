package com.gfttraining.WineDB.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gfttraining.WineDB.Model.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer>{
	
	@Query("select w from Wine w order by rating desc")
	public List<Wine> findAllOrderByRatingDesc(Pageable p);
	
	@Query("select w from Wine w order by w.price desc")
	public List<Wine> findAllOrderByPriceDesc(Pageable p);
	
	@Query("select w from Wine w order by w.rating/w.price desc")
	public List<Wine> findBestBanForTheBuck(Pageable p);
	
	@Query("Select distinct w.year from Wine w order by w.rating desc")
	List<String> findYearsWithBestRatedWine(Pageable p);
	
	List<Wine> findByYear(String year);
	

		
    
}
