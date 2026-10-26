
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static final String FILE_NAME = "employees.txt";

    public static void save(EmployeeService service) {
        try (BufferedWriter writer =
                 new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : service.getAllEmployees()) {
                writer.write(e.toFileString());
                writer.newLine();
            }

            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    public static void load(EmployeeService service) {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 4);

                if (data.length != 4) {
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String department = data[2];
                    double salary = Double.parseDouble(data[3]);

                    if (name.isBlank() || department.isBlank() || salary < 0) {
                        continue;
                    }

                    service.addEmployee(
                        new Employee(id, name, department, salary)
                    );
                } catch (NumberFormatException ignored) {
                    System.out.println("Skipping invalid record.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
        }
    }
}
