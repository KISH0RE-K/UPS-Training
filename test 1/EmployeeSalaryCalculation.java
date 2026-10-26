class Employee {
    int employeeId;
    String name;
    double basicSalary;

    Employee(int employeeId, String name, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Final Salary: " + calculateSalary());
        System.out.println();
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(int id, String name, double basicSalary) {
        super(id, name, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary * 1.20;
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeeSalaryCalculation {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTimeEmployee(1, "Arun", 30000),
            new PartTimeEmployee(2, "Priya", 80, 200)
        };

        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}