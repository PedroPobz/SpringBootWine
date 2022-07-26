package com.gfttraining.WineDB.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    float rating;
    int num_reviews;
    float price;
    int body;
    int acidity;

    @ManyToOne
    int winery_id;

    @ManyToOne
    int type_id;
    
    @ManyToOne
    int region_id;

    public Wine(){

    }

    public Wine(String name, int year, float rating, int num_reviews, float price, int body, int acidity, int winery_id,
            int type_id, int region_id) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
        this.winery_id = winery_id;
        this.type_id = type_id;
        this.region_id = region_id;
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

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setNum_reviews(int num_reviews) {
        this.num_reviews = num_reviews;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public void setAcidity(int acidity) {
        this.acidity = acidity;
    }

    public void setWinery_id(int winery_id) {
        this.winery_id = winery_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    public int getNum_reviews() {
        return num_reviews;
    }

    public float getPrice() {
        return price;
    }

    public int getBody() {
        return body;
    }

    public int getAcidity() {
        return acidity;
    }

    public int getWinery_id() {
        return winery_id;
    }

    public int getType_id() {
        return type_id;
    }

    public int getRegion_id() {
        return region_id;
    }

  

}
