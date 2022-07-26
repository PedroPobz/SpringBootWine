package com.gfttraining.WineDB.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Wine")
public class Wine {
    @Id
    @GeneratedValue
    int id;

    String name;
    int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winery_id", referencedColumnName = "id")
    private Winery winery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    public Wine(){

    }

    public Wine(String name, int year, float rating, int num_reviews, float price, int body, int acidity, int winery_id,
            int type_id, int region_id) {
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id){
        this.id = id;
    }
  

}
