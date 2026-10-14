package com.example.baitapsession04.controller;

import com.example.baitapsession04.dto.StudentEnrollmentRequest;
import com.example.baitapsession04.model.StudentEnrollment;
import com.example.baitapsession04.response.ApiResponse;
import com.example.baitapsession04.service.StudentEnrollmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/students-enrollments")
public class StudentEnrollmentController {

    private final StudentEnrollmentService studentEnrollmentService;

    @Autowired
    public StudentEnrollmentController(StudentEnrollmentService studentEnrollmentService) {
        this.studentEnrollmentService = studentEnrollmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> enrollStudent(@Valid @RequestBody StudentEnrollmentRequest req) {
        StudentEnrollment enrollment = studentEnrollmentService.enrollStudent(req.getStudentId(), req.getCourseId());
        return ResponseEntity.created(URI.create("/students-enrollments/" + enrollment.getId()))
                .body(ApiResponse.success("Đăng ký sinh viên vào khóa học thành công"));
    }
}
