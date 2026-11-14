package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // get all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    // save a new student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }
}
