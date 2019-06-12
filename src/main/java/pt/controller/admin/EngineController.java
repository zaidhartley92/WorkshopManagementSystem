package pt.controller.admin;

import pt.domain.Engine;
import pt.service.EngineService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/engine")
public class EngineController {
    @Qualifier("ServiceImpl")
    private EngineService service;

    @PostMapping("/create")
    @ResponseBody
    public Engine create(Engine engine){
        return service.create(engine);
    }

    @PostMapping("/update")
    @ResponseBody
    public Engine update(Engine engine){
        return service.update(engine);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Engine read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Engine> getAll(){
        return service.getAll();
    }
}