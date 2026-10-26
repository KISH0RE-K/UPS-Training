
import java.util.Scanner;

public class EmployeeRecordManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        FileManager.load(service);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Display All");
            System.out.println("6. Save and Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Enter department: ");
                        String department = sc.nextLine().trim();

                        System.out.print("Enter salary: ");
                        double salary = Double.parseDouble(sc.nextLine());

                        if (name.isEmpty() || department.isEmpty() || salary < 0) {
                            System.out.println("Invalid employee details.");
                            break;
                        }

                        Employee e = new Employee(id, name, department, salary);

                        if (service.addEmployee(e)) {
                            System.out.println("Employee added.");
                        } else {
                            System.out.println("Employee ID already exists.");
                        }
                        break;

                    case "2":
                        System.out.print("Enter employee ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        Employee found = service.searchEmployee(id);

                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case "3":
                        System.out.print("Enter employee ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new salary: ");
                        salary = Double.parseDouble(sc.nextLine());

                        if (service.updateSalary(id, salary)) {
                            System.out.println("Salary updated.");
                        } else {
                            System.out.println("Invalid ID or salary.");
                        }
                        break;

                    case "4":
                        System.out.print("Enter employee ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        if (service.deleteEmployee(id)) {
                            System.out.println("Employee deleted.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case "5":
                        service.displayEmployees();
                        break;

                    case "6":
                        FileManager.save(service);
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
