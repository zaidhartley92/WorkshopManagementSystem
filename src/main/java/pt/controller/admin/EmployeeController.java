package pt.controller.admin;

import pt.domain.Employee;
import pt.service.EmployeeService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Qualifier("ServiceImpl")
    private EmployeeService service;

    @PostMapping("/create")
    @ResponseBody
    public Employee create(Employee employee){
        return service.create(employee);
    }

    @PostMapping("/update")
    @ResponseBody
    public Employee update(Employee employee){
        return service.update(employee);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Employee read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Employee> getAll(){
        return service.getAll();
    }
}