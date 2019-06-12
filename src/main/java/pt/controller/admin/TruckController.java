package pt.controller.admin;

import pt.domain.Truck;
import pt.service.TruckService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/truck")
public class TruckController {
    @Qualifier("ServiceImpl")
    private TruckService service;

    @PostMapping("/create")
    @ResponseBody
    public Truck create(Truck truck){
        return service.create(truck);
    }

    @PostMapping("/update")
    @ResponseBody
    public Truck update(Truck truck){
        return service.update(truck);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Truck read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Truck> getAll(){
        return service.getAll();
    }
}