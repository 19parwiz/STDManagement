package com.Baktash.student_management.repository;

import com.Baktash.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

boolean existsByEmail(String email);




}
