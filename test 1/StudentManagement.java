
import java.util.*;

class Student {
    int rollNumber;
    String name;
    int mark;

    Student(int rollNumber, String name, int mark) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.mark = mark;
    }

    public String toString() {
        return rollNumber + " " + name + " " + mark;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Arun", 85));
        students.add(new Student(2, "Priya", 92));
        students.add(new Student(3, "Rahul", 68));
        students.add(new Student(4, "Divya", 78));
        students.add(new Student(5, "Kumar", 55));

        System.out.println("Students scoring above 75:");
        for (Student s : students) {
            if (s.mark > 75) {
                System.out.println(s);
            }
        }

        int searchRoll = 3;
        for (Student s : students) {
            if (s.rollNumber == searchRoll) {
                System.out.println("Found: " + s);
                s.mark = 80;
                break;
            }
        }

        students.removeIf(s -> s.rollNumber == 5);

        students.sort((a, b) -> Integer.compare(b.mark, a.mark));

        System.out.println("Students sorted by marks:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
