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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
