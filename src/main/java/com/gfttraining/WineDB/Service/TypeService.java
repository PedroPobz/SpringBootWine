package com.gfttraining.WineDB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfttraining.WineDB.Model.Type;
import com.gfttraining.WineDB.Repository.TypeRepository;

@Service
public class TypeService {
    
    @Autowired 
    TypeRepository typeRepository;

    public Type findById(int id){
        return typeRepository.findById(id).get();
    }

    public Type createtype(Type type){
        return typeRepository.save(type);
     }
 
     public void deletetype(int id){
         typeRepository.deleteById(id);
     }
}
