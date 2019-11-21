package com.example.demo.CONTROLLER;

import com.example.demo.DTO.BayDTO;
import com.example.demo.MODEL.Bay;
import com.example.demo.REPOSITORY.BayRepository;
import com.example.demo.SERVICE.BayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/bay")
public class BayController {

    @Autowired
    BayRepository bayRepository;

    @Autowired
    BayService bayService;

    @PostMapping("/create")
    public String createBay(@RequestBody BayDTO bayDTO){
        return this.bayService.saveBay(bayDTO);
    }

    @GetMapping("/getall")
    public List<Bay> getAll(){
        return this.bayService.getAll();
    }


    @PutMapping("/update/{id}")
    public String updateBay(@PathVariable ("id") Long id,@RequestBody BayDTO bayDTO){
        return this.bayService.update(id,bayDTO);
    }

    @DeleteMapping("/delete/{id}")
    public List<Bay> deleteBay(@PathVariable ("id") Long id){
        return this.bayService.delete(id);
    }


}
