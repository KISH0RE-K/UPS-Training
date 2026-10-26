
import java.io.*;
import java.util.*;

class StudentRecord {
    int id;
    String name;
    double marks;

    StudentRecord(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + "," + name + "," + marks;
    }
}

public class StudentRecords {
    public static void main(String[] args) {
        String fileName = "students.txt";

        try {
            try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {
                writer.write(new StudentRecord(1, "Arun", 85).toString());
                writer.newLine();
                writer.write(new StudentRecord(2, "Priya", 95).toString());
                writer.newLine();
                writer.write(new StudentRecord(3, "Rahul", 72).toString());
                writer.newLine();
                writer.write(new StudentRecord(4, "Divya", 88).toString());
                writer.newLine();
                writer.write(new StudentRecord(5, "Kumar", 91).toString());
                writer.newLine();
            }

            StudentRecord topper = null;

            try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    String[] parts = line.split(",", 3);
                    StudentRecord student = new StudentRecord(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        Double.parseDouble(parts[2])
                    );

                    if (topper == null || student.marks > topper.marks) {
                        topper = student;
                    }
                }
            }

            if (topper != null) {
                System.out.println("Topper: " + topper.name);
                System.out.println("Highest marks: " + topper.marks);
            }

            try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(new StudentRecord(6, "Vijay", 79).toString());
                writer.newLine();
            }

            System.out.println("New student appended successfully.");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
