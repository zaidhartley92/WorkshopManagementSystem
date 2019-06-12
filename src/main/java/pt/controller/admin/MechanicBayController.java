package pt.controller.admin;

import pt.domain.MechanicBay;
import pt.service.MechanicBayService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/mechanicBay")
public class MechanicBayController {
    @Qualifier("ServiceImpl")
    private MechanicBayService service;

    @PostMapping("/create")
    @ResponseBody
    public MechanicBay create(MechanicBay mechanicBay){
        return service.create(mechanicBay);
    }

    @PostMapping("/update")
    @ResponseBody
    public MechanicBay update(MechanicBay mechanicBay){
        return service.update(mechanicBay);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public MechanicBay read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<MechanicBay> getAll(){
        return service.getAll();
    }
}