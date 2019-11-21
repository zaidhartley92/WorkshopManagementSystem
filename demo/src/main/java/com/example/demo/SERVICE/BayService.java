package com.example.demo.SERVICE;

//package pt.service.impl;


import com.example.demo.REPOSITORY.BayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.BayDTO;
import com.example.demo.MODEL.Bay;


import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

@Service
public class BayService {

    @Autowired
    BayRepository bayNewRepository;

    public String saveBay(BayDTO bayDTO){

        Bay bayModel = new Bay();
        bayModel.setBayId(bayDTO.getBayId());
        bayModel.setName(bayDTO.getName());
        bayModel.setSurname(bayDTO.getSurname());
//        TreeSet<Bay> bayTreeSet = new TreeSet<>()
        this.bayNewRepository.save(bayModel);
        return "{\"successful\":1}";
    }
    public List<Bay> getAll(){
        List<Bay> bayModelList =  bayNewRepository.findAll();
        return  bayModelList;
    }

    public String update(Long id,BayDTO bayDTO){
        Optional<Bay> bay = bayNewRepository.findById(id);

        if(bay.isPresent()){
            Bay updatedBay = bay.get();
            updatedBay.setBayId(bayDTO.getBayId());
            updatedBay.setName(bayDTO.getName());
            updatedBay.setSurname(bayDTO.getSurname());
            this.bayNewRepository.save(updatedBay);
            return "{\" UPDATED SUCCESFULLY\":1}";
        }
        else{
            return null;
        }

    }

    public List<Bay> delete(Long id){
        Optional<Bay> bayModel = bayNewRepository.findById(id);

        if(bayModel.isPresent()){
            bayNewRepository.deleteById(id);
        }

        return this.getAll();
    }

}
