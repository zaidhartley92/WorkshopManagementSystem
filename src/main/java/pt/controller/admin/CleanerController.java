package pt.controller.admin;

import pt.domain.Cleaner;
import pt.service.CleanerService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cleaner")
public class CleanerController {
    @Qualifier("ServiceImpl")
    private CleanerService service;

    @PostMapping("/create")
    @ResponseBody
    public Cleaner create(Cleaner cleaner){
        return service.create(cleaner);
    }

    @PostMapping("/update")
    @ResponseBody
    public Cleaner update(Cleaner cleaner){
        return service.update(cleaner);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Cleaner read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Cleaner> getAll(){
        return service.getAll();
    }
}
