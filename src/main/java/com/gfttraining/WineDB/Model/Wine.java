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
    float rating;
    int num_reviews;
    float price;
    int body;
    int acidity;

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
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
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


  

}
