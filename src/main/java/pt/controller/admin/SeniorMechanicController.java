package pt.controller.admin;

import pt.domain.SeniorMechanic;
import pt.service.SeniorMechanicService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/seniorMechanic")
public class SeniorMechanicController {
    @Qualifier("ServiceImpl")
    private SeniorMechanicService service;

    @PostMapping("/create")
    @ResponseBody
    public SeniorMechanic create(SeniorMechanic seniorMechanic){
        return service.create(seniorMechanic);
    }

    @PostMapping("/update")
    @ResponseBody
    public SeniorMechanic update(SeniorMechanic seniorMechanic){
        return service.update(seniorMechanic);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public SeniorMechanic read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<SeniorMechanic> getAll(){
        return service.getAll();
    }
}