package pt.service;
import pt.domain.Employee;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String>{

    Set<Employee> getAll();
}
