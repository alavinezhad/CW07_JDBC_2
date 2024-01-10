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
    public void editOfficeCode(int employeeNumber) throws SQLException {
        System.out.println("***** edit employee office code *****");
        Employee employee = employeeRepository.findEmployeeById(employeeNumber);
        System.out.println(employeeNumber);
        System.out.println("New office code:");
        int newOfficeCode = scanner.nextInt();
        scanner.nextLine();
        int result = employeeRepository.updateOfficeCode(newOfficeCode);
        if (result == 1) {
            System.out.println("office code is updated.");
            System.out.println(employeeRepository.findEmployeeById(employeeNumber));
        }
        else
            System.out.println("new office code is not applied.");
    }
    public void editAddress(int employeeNumber) throws SQLException {
        System.out.println("***** edit address *****");
        System.out.println("Enter new Address");
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("Street:");
        String street = scanner.nextLine();
        System.out.println("Postal code:");
        int postalCode = scanner.nextInt();
        int result = employeeRepository.updateAddress(
                new EmployeeAddress(city, street, postalCode), employeeNumber);
        if (result == 1)
            System.out.println("address is changed.");
        else
            System.out.println("new address is not applied.");
    }

}
