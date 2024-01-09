package repository;

import entities.Employee;

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

}
