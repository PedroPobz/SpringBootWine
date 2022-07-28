package com.gfttraining.WineDB.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gfttraining.WineDB.Validation.MaxCurrentYear;

@Entity
@Table(name="Wine")
public class Wine {
    @Id
    @GeneratedValue
    int id;

    @NotBlank(message= "Wrong name")
    String name;

    @Min(value= 1900, message= "Wrong year") @MaxCurrentYear
    String year;

    @Range(min = 0, max = 5, message = "Wrong rating")
    double rating;

    @Range(min = 1, max = 5, message = "Wrong body")
    String body;

    @Range(min = 1, max = 5, message = "Wrong acidity")
    String acidity;

    @Min(value = 0, message = "Wrong number of reviews")
    int num_reviews;

    @Positive(message = "Wrong price")
    double price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winery_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Winery winery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Type type;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    public Wine(){

    }



    

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNum_reviews() {
        return num_reviews;
    }

    public void setNum_reviews(int num_reviews) {
        this.num_reviews = num_reviews;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAcidity() {
        return acidity;
    }

    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }


    public Winery getWinery() {
        return winery;
    }

    public void setWinery(Winery winery) {
        this.winery = winery;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public void setId(int id){
        this.id = id;
    }
  

}
