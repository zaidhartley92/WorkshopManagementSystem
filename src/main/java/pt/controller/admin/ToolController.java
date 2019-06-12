package pt.controller.admin;

import pt.domain.Tool;
import pt.service.ToolService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/tool")
public class ToolController {
    @Qualifier("ServiceImpl")
    private ToolService service;

    @PostMapping("/create")
    @ResponseBody
    public Tool create(Tool tool){
        return service.create(tool);
    }

    @PostMapping("/update")
    @ResponseBody
    public Tool update(Tool tool){
        return service.update(tool);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Tool read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Tool> getAll(){
        return service.getAll();
    }
}