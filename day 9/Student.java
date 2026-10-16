
class Student {
    int rollNumber;
    String name;
    int[] marks;

    Student(int rollNumber, String name, int[] marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    double calculateAverage() {
        return calculateTotal() / 5.0;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 90)
            return 'A';
        else if (average >= 75)
            return 'B';
        else if (average >= 60)
            return 'C';
        else if (average >= 40)
            return 'D';
        else
            return 'F';
    }

    void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Total: " + calculateTotal());
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + calculateGrade());
        System.out.println();
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Arun",
                new int[]{80, 85, 90, 85, 85});

        Student s2 = new Student(2, "Priya",
                new int[]{95, 92, 98, 96, 94});

        Student s3 = new Student(3, "Rahul",
                new int[]{65, 70, 75, 68, 72});

        Student[] students = {s1, s2, s3};

        for (Student s : students) {
            s.display();
        }
    }
}
