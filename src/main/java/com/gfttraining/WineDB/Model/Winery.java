package com.gfttraining.WineDB.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Winery")
public class Winery {
    @Id
    @GeneratedValue
    int id;

    String name;

    public Winery(){

    }

    public Winery(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
