package com.Baktash.student_management.controller;

import com.Baktash.student_management.entity.Student;
import com.Baktash.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService  studentService) {
        this.studentService = studentService;

    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());

    }

// Get students by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    // Post: Create new student
    @PostMapping
    public ResponseEntity<Student>addStudent(@RequestBody Student student ) {
        Student CreatedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(CreatedStudent);

    }
    // Put: update the students
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student
    )
    {
        Student updatedStudent = studentService.uppdateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }


    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(
            @PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }







}
