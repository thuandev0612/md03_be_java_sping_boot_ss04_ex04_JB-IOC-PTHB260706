package com.example.baitapsession04.controller;

import com.example.baitapsession04.dto.CourseCreateRequest;
import com.example.baitapsession04.dto.CourseUpdateRequest;
import com.example.baitapsession04.model.Course;
import com.example.baitapsession04.response.ApiResponse;
import com.example.baitapsession04.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createCourse(@Valid @RequestBody CourseCreateRequest req) {
        Course course = courseService.createCourse(req);
        return ResponseEntity.created(URI.create("/courses/" + course.getId()))
                .body(ApiResponse.success("Tạo khóa học thành công"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateCourse(
            @PathVariable @Positive Long id, @Valid @RequestBody CourseUpdateRequest req) {
        courseService.updateCourse(id, req);
        return ResponseEntity.ok(ApiResponse.success("Cập nhật khóa học thành công"));
    }
}
