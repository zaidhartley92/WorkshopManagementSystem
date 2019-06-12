package pt.factory;

import pt.domain.Employee;
import pt.util.Misc;

public class EmployeeFactory {
    public static Employee getEmployee(String Name) {
        return new Employee.Builder().employeeId(Misc.generateId())
                .name(Name)
                .build();
    }

}

