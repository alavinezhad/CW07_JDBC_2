package entities;

public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private int officeCode;
    private int addressId;

    public Employee() {
    }

    public Employee(int employeeNumber,
                    String lastName,
                    String firstName,
                    int officeCode,
                    int addressId) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.officeCode = officeCode;
        this.addressId = addressId;
    }

}
