import java.util.Objects;

public class Employee {
    final private int id;
    final private String firstName;
    final private String lastName;
    final private String gender;
    final private int age;
    final private int cityId;

    public Employee(int id, String lastName, String firstName, String gender, int age, int cityId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getCityId() {
        return cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(gender, employee.gender) && Objects.equals(age, employee.age) && Objects.equals(cityId, employee.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, gender, age, cityId);
    }

    @Override
    public String toString() {
        return "(" +
                "id = " + id +
                ", lastName = " + lastName +
                ", firstName = " + firstName +
                ", gender = " + gender +
                ", age = " + age +
                ", city_id = " + cityId +
                ')';
    }
}
