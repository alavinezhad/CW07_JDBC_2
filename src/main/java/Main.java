import entities.EmployeeAddress;
import service.EmployeeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeService employeeService = new EmployeeService();

/*
        int employeeNumber = employeeService.addEmployee();
        if (employeeNumber != -1)
            System.out.println("employee is added with Employee Number: " + employeeNumber);
*/

        employeeService.editOfficeCode(2);
        employeeService.editAddress(2);

/*
        EmployeeAddress employeeAddress = employeeService.findAddress(3);
        if (employeeAddress == null)
            System.out.println("address not found.");
        else
            System.out.println(employeeAddress);
*/
    }
}
