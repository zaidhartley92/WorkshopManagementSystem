package pt.controller.admin;

import pt.domain.Car;
import pt.service.CarService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/car")
public class CarController {
    @Qualifier("ServiceImpl")
    private CarService service;

    @PostMapping("/create")
    @ResponseBody
    public Car create(Car car){
        return service.create(car);
    }

    @PostMapping("/update")
    @ResponseBody
    public Car update(Car car){
        return service.update(car);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Car read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Car> getAll(){
        return service.getAll();
    }
}