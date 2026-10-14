# Kết quả kiểm tra Session04 bài 4

Ngày kiểm tra: 15/10/2026 (giờ Việt Nam).

## Build và JUnit

Lệnh `gradlew.bat test bootJar` với JDK 21: **BUILD SUCCESSFUL**.

| Bộ test | Số test | Thất bại/lỗi |
| --- | --- | --- |
| EntityMappingTests | 14 | 0 |
| RepositoryServiceTests | 4 | 0 |
| CourseEnrollmentApiTests | 14 | 0 |
| Tổng | 32 | 0 |

JUnit dùng PostgreSQL thật và rollback dữ liệu test.

## Chạy collection Postman qua Newman

Đã khởi động file JAR trên localhost, chạy collection bằng **Newman 6.2.3**: **8 request, 36 assertions, 0 lỗi**. Không chạy qua giao diện Postman desktop.

| Request | HTTP nhận được |
| --- | --- |
| POST /instructors | 201 |
| POST /courses | 201 |
| PUT /courses/45 | 200 |
| POST /students | 201 |
| POST /students-enrollments | 201 |
| Tạo khóa học với instructorId không tồn tại | 404 |
| Đăng ký với courseId không tồn tại | 404 |
| Tạo sinh viên với email sai định dạng | 400 |

Mỗi response được kiểm tra `success`, thông điệp và `data = null`; bốn POST thành công còn kiểm tra header Location.

## Dữ liệu đã lưu trên máy này

Đã đối chiếu bằng truy vấn JOIN trực tiếp trong database `course_management_session04`:

- Instructor ID: **42**.
- Course ID: **45**, status **ACTIVE**.
- Student ID: **20**.
- StudentEnrollment ID: **19**, liên kết Student 20 với Course 45, giảng viên 42.

Đây là một bộ dữ liệu demo do collection tạo; giữ lại để xem trong pgAdmin. Chạy lại collection sẽ có ID khác. Ứng dụng đã được dừng sau kiểm tra; chạy lại `BaitapSession04Application` để thử Postman.
