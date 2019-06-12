package pt.controller.admin;

import pt.domain.Manager;
import pt.service.ManagerService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Qualifier("ServiceImpl")
    private ManagerService service;

    @PostMapping("/create")
    @ResponseBody
    public Manager create(Manager manager){
        return service.create(manager);
    }

    @PostMapping("/update")
    @ResponseBody
    public Manager update(Manager manager){
        return service.update(manager);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Manager read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Manager> getAll(){
        return service.getAll();
    }
}