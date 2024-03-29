package repository;

import entities.Employee;
import entities.EmployeeAddress;

import java.sql.*;

public class EmployeeRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public EmployeeRepository() throws SQLException {
    }

    public int save(Employee employee) throws SQLException {
        String addEmployee = "INSERT INTO employee (last_name, first_name, office_code, address_id) \n" +
                "VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addEmployee,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, employee.getLastName());
        preparedStatement.setString(2, employee.getFirstName());
        preparedStatement.setInt(3, employee.getOfficeCode());
        preparedStatement.setInt(4, employee.getAddressId());

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next())
           return (int) resultSet.getLong(1);
        else
            return -1;
    }
    public int save(EmployeeAddress address) throws SQLException {
        String addAddress = "INSERT INTO employee_address (city, street, postal_code) \n" +
                "VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addAddress,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, address.getCity());
        preparedStatement.setString(2, address.getStreet());
        preparedStatement.setInt(3, address.getPostalCode());

        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next())
            return (int) resultSet.getLong(1);

        return -1;
    }
    public EmployeeAddress loadAddress(int employeeNumber) throws SQLException {
        String findAddress = "SELECT A.* \n" +
                "FROM employee_address A\n" +
                "JOIN employee E USING (address_id)\n" +
                "WHERE E.employee_number = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(findAddress);
        preparedStatement.setInt(1, employeeNumber);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("address_id");
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            int postalCode = resultSet.getInt("postal_code");
            return new EmployeeAddress(id, city, street, postalCode);
        }
        return null;
    }

    public Employee findEmployeeById(int employeeId) throws SQLException {
        String findEmployee = "SELECT * FROM employee WHERE employee_number = ?;";
        PreparedStatement ps = connection.prepareStatement(findEmployee);
        ps.setInt(1, employeeId);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            int employeeNumber = resultSet.getInt("employee_number");
            String lastName = resultSet.getString("last_name");
            String firstName = resultSet.getString("first_name");
            int officeCode = resultSet.getInt("office_code");
            int addressId = resultSet.getInt("address_id");

            return new Employee(employeeNumber, lastName, firstName, officeCode, addressId);
        }
        return null;
    }
    public int updateAddress(EmployeeAddress employeeAddress) throws SQLException {
        String changeAddress = "UPDATE employee_address A\n" +
                "SET city = ?, street = ?, postal_code = ?\n" +
                "WHERE address_id = ?;";
        PreparedStatement ps = connection.prepareStatement(changeAddress);
        ps.setString(1, employeeAddress.getCity());
        ps.setString(2, employeeAddress.getStreet());
        ps.setInt(3, employeeAddress.getPostalCode());
        ps.setInt(4, employeeAddress.getAddressId());

        int result = ps.executeUpdate();
        return result;
    }
    public int updateOfficeCode(int newOfficeCode) throws SQLException {
        String changeOfficeCode = "UPDATE employee SET office_code = ?;";
        PreparedStatement ps = connection.prepareStatement(changeOfficeCode);
        ps.setInt(1, newOfficeCode);
        int result = ps.executeUpdate();
        return result;
    }
    public int delete(int employeeId) throws SQLException {
        String deleteEmployee = "DELETE FROM employee WHERE employee_number = ?;";
        PreparedStatement ps = connection.prepareStatement(deleteEmployee);
        ps.setInt(1, employeeId);

        return ps.executeUpdate();
    }
    public int deleteAddress(int addressId) throws SQLException {
        String deleteAddress = "DELETE FROM employee_address WHERE address_id = ?;";
        PreparedStatement ps = connection.prepareStatement(deleteAddress);
        ps.setInt(1, addressId);

        return ps.executeUpdate();
    }

}
