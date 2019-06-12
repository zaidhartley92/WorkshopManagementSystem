package pt.controller.admin;

import pt.domain.Window;
import pt.service.WindowService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/window")
public class WindowController {
    @Qualifier("ServiceImpl")
    private WindowService service;

    @PostMapping("/create")
    @ResponseBody
    public Window create(Window window){
        return service.create(window);
    }

    @PostMapping("/update")
    @ResponseBody
    public Window update(Window window){
        return service.update(window);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Window read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Window> getAll(){
        return service.getAll();
    }
}