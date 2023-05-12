import java.sql.*;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "051021";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        //Task №1
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT first_name, last_name, gender, age, c.city_name  FROM employee e LEFT JOIN city c on c.city_id = e.city_id WHERE e.id = ?;")) {
            //получить и вывести в консоль полные данные об одном из работников(имя, фамилия, пол, город) по id
            int id = 4; //ID - 1, 2, 4, 5, 6
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            System.out.printf("Имя - %s, Фамилия - %s, пол - %s, возраст - %d, город - %s\n",
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5));

            //Task №2
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            employeeDAO.addEmployee("Melnikov", "Aleksey", "M", 20, 3);
            System.out.println(employeeDAO.receiptEmployeeById(7).toString());
            employeeDAO.changingEmployeeId(6, "last_name = 'Kviten'", "first_name = 'Viktor'");
            System.out.println(employeeDAO.gettingListAllEmployee());
            employeeDAO.deleteEmployeeId(7);

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }
}