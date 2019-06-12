package pt.controller.admin;

import pt.domain.Bay;
import pt.service.BayService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bay")
public class BayController {
    @Qualifier("ServiceImpl")
    private BayService service;

    @PostMapping("/create")
    @ResponseBody
    public Bay create(Bay bay){
        return service.create(bay);
    }

    @PostMapping("/update")
    @ResponseBody
    public Bay update(Bay bay){
        return service.update(bay);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Bay read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Bay> getAll(){
        return service.getAll();
    }
}