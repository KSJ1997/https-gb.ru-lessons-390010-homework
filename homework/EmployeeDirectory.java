import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    public String findPhoneNumberByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee.getPhoneNumber();
            }
        }
        return "Номер телефона не найден для сотрудника: " + name;
    }

    public Employee findEmployeeByEmployeeId(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        directory.addEmployee(new Employee(1, "123-456-7890", "Иван Иванов", 5));
        directory.addEmployee(new Employee(2, "987-654-3210", "Мария Сидорова", 3));

        List<Employee> employeesWithExperience5 = directory.findEmployeesByExperience(5);
        System.out.println("Сотрудники со стажем 5: " + employeesWithExperience5);

        String phoneNumber = directory.findPhoneNumberByName("Мария Сидорова");
        System.out.println("Номер телефона для Марии Сидоровой: " + phoneNumber);

        Employee employeeById = directory.findEmployeeByEmployeeId(1);
        System.out.println("Сотрудник с табельным номером 1: " + employeeById);
    }
}

class Employee {
    private int employeeId;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int employeeId, String phoneNumber, String name, int experience) {
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Сотрудник{" +
                "табельныйНомер=" + employeeId +
                ", номерТелефона='" + phoneNumber + '\'' +
                ", имя='" + name + '\'' +
                ", стаж=" + experience +
                '}';
    }
}
