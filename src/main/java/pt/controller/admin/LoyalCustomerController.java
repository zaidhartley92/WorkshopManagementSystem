package pt.controller.admin;

import pt.domain.LoyalCustomer;
import pt.service.LoyalCustomerService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/loyalCustomer")
public class LoyalCustomerController {
    @Qualifier("ServiceImpl")
    private LoyalCustomerService service;

    @PostMapping("/create")
    @ResponseBody
    public LoyalCustomer create(LoyalCustomer loyalCustomer){
        return service.create(loyalCustomer);
    }

    @PostMapping("/update")
    @ResponseBody
    public LoyalCustomer update(LoyalCustomer loyalCustomer){
        return service.update(loyalCustomer);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public LoyalCustomer read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<LoyalCustomer> getAll(){
        return service.getAll();
    }
}