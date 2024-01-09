package entities;

public class EmployeeAddress {
    private int addressId;
    private String city;
    private String street;
    private int postalCode;

    public EmployeeAddress() {
    }

    public EmployeeAddress(int addressId, String city, String street, int postalCode) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public EmployeeAddress(String city, String street, int postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }
}
