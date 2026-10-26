
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EmployeeService {
    private ArrayList<Employee> employees = new ArrayList<>();
    private HashMap<Integer, Employee> employeeMap = new HashMap<>();
    private HashSet<Integer> employeeIds = new HashSet<>();

    public boolean addEmployee(Employee e) {
        if (employeeIds.contains(e.getId())) {
            return false;
        }

        employees.add(e);
        employeeMap.put(e.getId(), e);
        employeeIds.add(e.getId());
        return true;
    }

    public Employee searchEmployee(int id) {
        return employeeMap.get(id);
    }

    public boolean updateSalary(int id, double salary) {
        Employee e = employeeMap.get(id);

        if (e == null || salary < 0) {
            return false;
        }

        e.setSalary(salary);
        return true;
    }

    public boolean deleteEmployee(int id) {
        Employee e = employeeMap.remove(id);

        if (e == null) {
            return false;
        }

        employees.remove(e);
        employeeIds.remove(id);
        return true;
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
