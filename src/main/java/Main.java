import entities.EmployeeAddress;
import service.EmployeeService;
import service.Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
        Menu menu = new Menu();
        menu.menu();

    }
}
