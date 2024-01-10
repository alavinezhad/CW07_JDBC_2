package service;

import entities.EmployeeAddress;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final EmployeeService employeeService = new EmployeeService();
    private final Scanner scanner = new Scanner(System.in);
    public void menu() throws SQLException {
        System.out.println("**********************************************");
        System.out.println("1- add employee information");
        System.out.println("2- enter employee number to get address");
        System.out.println("3- edit employee office code and address");
        System.out.println("4- enter empolyee number to delete an employee");
        System.out.println("choose a number:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                int employeeNumber = employeeService.addEmployee();
                if (employeeNumber != -1)
                    System.out.println("employee is added with Employee Number: "
                            + employeeNumber);
            }
            case 2 -> {
                int employeeNumber = getEmployeeNumber();
                EmployeeAddress employeeAddress = employeeService.findAddress(employeeNumber);
                if (employeeAddress == null)
                    System.out.println("address not found.");
                else
                    System.out.println(employeeAddress);
            }
            case 3 -> {
                int employeeNumber = getEmployeeNumber();
                employeeService.editOfficeCode(employeeNumber);
                employeeService.editAddress(employeeNumber);
            }
            case 4 -> {
                int employeeNumber = getEmployeeNumber();
                employeeService.deleteEmployee(2);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
    private int getEmployeeNumber() {
        System.out.println("Enter employee number to edit information");
        int employeeNumber = scanner.nextInt();
        scanner.nextLine();
        return employeeNumber;
    }
}
