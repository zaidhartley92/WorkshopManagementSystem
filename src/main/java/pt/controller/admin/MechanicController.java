package pt.controller.admin;

import pt.domain.Mechanic;
import pt.service.MechanicService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/mechanic")
public class MechanicController {
    @Qualifier("ServiceImpl")
    private MechanicService service;

    @PostMapping("/create")
    @ResponseBody
    public Mechanic create(Mechanic mechanic){
        return service.create(mechanic);
    }

    @PostMapping("/update")
    @ResponseBody
    public Mechanic update(Mechanic mechanic){
        return service.update(mechanic);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Mechanic read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Mechanic> getAll(){
        return service.getAll();
    }
}