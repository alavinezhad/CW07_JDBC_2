package service;

import entities.Employee;
import entities.EmployeeAddress;
import repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeService {
    private final Scanner scanner = new Scanner(System.in);
    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    public EmployeeService() throws SQLException {
    }

    public int addEmployee() throws SQLException {
        System.out.println("***** add employee information *****");
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        System.out.println("Office code:");
        int officeCode = scanner.nextInt();
        scanner.nextLine();

        System.out.println("***** address of employee *****");
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("Street:");
        String street = scanner.nextLine();
        System.out.println("Postal Code:");
        int postalCode = scanner.nextInt();
        scanner.nextLine();

        int addressId = employeeRepository.save(new EmployeeAddress(city, street, postalCode));

        int employeeNumber = employeeRepository.save(new Employee(lastName, firstName, officeCode, addressId));
        return employeeNumber;
    }
    public EmployeeAddress findAddress(int employeeNumber) throws SQLException {
        return employeeRepository.loadAddress(employeeNumber);
    }
}
