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
        String addEmployee = "INSERT INTO employees (last_name, first_name, office_code, address_id) \n" +
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
        String addAddress = "INSERT INTO employee_address (address_id, city, street, postal_code) \n" +
                "VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addAddress,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, address.getAddressId());
        preparedStatement.setString(2, address.getCity());
        preparedStatement.setString(3, address.getStreet());
        preparedStatement.setInt(4, address.getPostalCode());

        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next())
            return (int) resultSet.getLong(1);

        return -1;
    }

}
