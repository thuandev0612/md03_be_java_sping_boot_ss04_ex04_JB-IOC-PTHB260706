package com.example.baitapsession04.repository;

import com.example.baitapsession04.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
