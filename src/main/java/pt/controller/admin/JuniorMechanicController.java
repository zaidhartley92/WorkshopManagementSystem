package pt.controller.admin;

import pt.domain.JuniorMechanic;
import pt.service.JuniorMechanicService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/juniorMechanic")
public class JuniorMechanicController {
    @Qualifier("ServiceImpl")
    private JuniorMechanicService service;

    @PostMapping("/create")
    @ResponseBody
    public JuniorMechanic create(JuniorMechanic juniorMechanic){
        return service.create(juniorMechanic);
    }

    @PostMapping("/update")
    @ResponseBody
    public JuniorMechanic update(JuniorMechanic juniorMechanic){
        return service.update(juniorMechanic);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public JuniorMechanic read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<JuniorMechanic> getAll(){
        return service.getAll();
    }
}