package pt.controller.admin;

import pt.domain.TraineeMechanic;
import pt.service.TraineeMechanicService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/traineeMechanic")
public class TraineeMechanicController {
    @Qualifier("ServiceImpl")
    private TraineeMechanicService service;

    @PostMapping("/create")
    @ResponseBody
    public TraineeMechanic create(TraineeMechanic traineeMechanic){
        return service.create(traineeMechanic);
    }

    @PostMapping("/update")
    @ResponseBody
    public TraineeMechanic update(TraineeMechanic traineeMechanic){
        return service.update(traineeMechanic);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public TraineeMechanic read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<TraineeMechanic> getAll(){
        return service.getAll();
    }
}