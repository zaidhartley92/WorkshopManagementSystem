package pt.controller.admin;

import pt.domain.Tire;
import pt.service.TireService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/tire")
public class TireController {
    @Qualifier("ServiceImpl")
    private TireService service;

    @PostMapping("/create")
    @ResponseBody
    public Tire create(Tire tire){
        return service.create(tire);
    }

    @PostMapping("/update")
    @ResponseBody
    public Tire update(Tire tire){
        return service.update(tire);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Tire read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Tire> getAll(){
        return service.getAll();
    }
}