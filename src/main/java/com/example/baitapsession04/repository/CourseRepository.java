package com.example.baitapsession04.repository;

import com.example.baitapsession04.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
