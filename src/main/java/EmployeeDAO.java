import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(String lastname, String firstname, String gender, int age, int city_id) throws SQLException;
    Employee receiptEmployeeById(int id) throws SQLException;
    List<Employee> gettingListAllEmployee() throws SQLException;
    void changingEmployeeId(int id, String... array) throws SQLException;
    void deleteEmployeeId(int id) throws SQLException;
}
