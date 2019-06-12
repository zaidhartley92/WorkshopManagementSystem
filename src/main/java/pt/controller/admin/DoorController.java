package pt.controller.admin;

import pt.domain.Door;
import pt.service.DoorService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/door")
public class DoorController {
    @Qualifier("ServiceImpl")
    private DoorService service;

    @PostMapping("/create")
    @ResponseBody
    public Door create(Door door){
        return service.create(door);
    }

    @PostMapping("/update")
    @ResponseBody
    public Door update(Door door){
        return service.update(door);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Door read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Door> getAll(){
        return service.getAll();
    }
}