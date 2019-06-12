package pt.controller.admin;

import pt.domain.Vehicle;
import pt.service.VehicleService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Qualifier("ServiceImpl")
    private VehicleService service;

    @PostMapping("/create")
    @ResponseBody
    public Vehicle create(Vehicle vehicle){
        return service.create(vehicle);
    }

    @PostMapping("/update")
    @ResponseBody
    public Vehicle update(Vehicle vehicle){
        return service.update(vehicle);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Vehicle read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Vehicle> getAll(){
        return service.getAll();
    }
}