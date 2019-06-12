package pt.controller.admin;

import pt.domain.ParkingBay;
import pt.service.ParkingBayService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/parkingBay")
public class ParkingBayController {
    @Qualifier("ServiceImpl")
    private ParkingBayService service;

    @PostMapping("/create")
    @ResponseBody
    public ParkingBay create(ParkingBay parkingBay){
        return service.create(parkingBay);
    }

    @PostMapping("/update")
    @ResponseBody
    public ParkingBay update(ParkingBay parkingBay){
        return service.update(parkingBay);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ParkingBay read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<ParkingBay> getAll(){
        return service.getAll();
    }
}