package pt.controller.admin;

import pt.domain.Reception;
import pt.service.ReceptionService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/secretary")
public class ReceptionController {
    @Qualifier("ServiceImpl")
    private ReceptionService service;

    @PostMapping("/create")
    @ResponseBody
    public Reception create(Reception reception){
        return service.create(reception);
    }

    @PostMapping("/update")
    @ResponseBody
    public Reception update(Reception reception){
        return service.update(reception);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Reception read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Reception> getAll(){
        return service.getAll();
    }
}