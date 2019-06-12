package pt.controller.admin;

import pt.domain.Bike;
import pt.service.BikeService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Qualifier("ServiceImpl")
    private BikeService service;

    @PostMapping("/create")
    @ResponseBody
    public Bike create(Bike bike){
        return service.create(bike);
    }

    @PostMapping("/update")
    @ResponseBody
    public Bike update(Bike bike){
        return service.update(bike);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Bike read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Bike> getAll(){
        return service.getAll();
    }
}