package com.Baktash.student_management.service;

import com.Baktash.student_management.entity.Student;
import com.Baktash.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;

    }


    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a single studentby id;
    public Optional<Student> getStudentById(Long id) {
        return getStudentById(id);
    }

    // add a new student
    public Student addStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Email already exists");

        }
        return studentRepository.save(student);
    }
// update student

    public Student uppdateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student not found with id " + id));
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());

        return studentRepository.save(student);
    }

    // Delete student
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("Student not found with id " + id);

        }
        studentRepository.deleteById(id);
    }
}




