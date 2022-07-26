package com.gfttraining.WineDB.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Winery")
public class Winery {
    @Id
    @GeneratedValue
    int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "winery")
    private List<Wine> wines;

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

    public void setId(int id){
        this.id = id;
    }
}
