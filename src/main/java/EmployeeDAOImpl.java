import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addEmployee(String firstname, String name, String gender, int age, int city_id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (last_name, first_name, gender, age, city_id) VALUES (?,?,?,?,?)");
        statement.setString(1, name);
        statement.setString(2, firstname);
        statement.setString(3, gender);
        statement.setInt(4, age);
        statement.setInt(5, city_id);
        statement.execute();
        System.out.println("Сотрудник успешно создан.\n");
    }

    @Override
    public Employee receiptEmployeeById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, last_name, first_name, gender, age, city_id FROM employee e WHERE e.id = ?;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Employee(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getInt(5),
                resultSet.getInt(6));
    }

    @Override
    public List<Employee> gettingListAllEmployee() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM employee e;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            employeeList.add(new Employee(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6)));
        }
        return employeeList;
    }

    @Override
    public void changingEmployeeId(int id, String... array) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE employee SET " + String.join(", ", array) + " WHERE id = ?;");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        System.out.printf("Изменение объекта по id - %s, выполнено.\n",id);
    }

    @Override
    public void deleteEmployeeId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM employee e WHERE e.id = ?;");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        System.out.printf("Удаление объекта Employee - %s, выполнено.\n",id);
    }
}
