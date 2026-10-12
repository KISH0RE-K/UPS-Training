public class Student {
    String name;
    int age;
    int id;

    Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + id);
    }
}