# Postman - Session04 bài 4

1. Khởi động project `baitapSession04` và PostgreSQL theo README ở thư mục gốc.
2. Trong Postman, chọn **Import** và mở `Session04-Bai4.postman_collection.json`.
3. Kiểm tra collection variable `baseUrl` (mặc định `http://localhost:8080`). Không đặt environment variable trùng tên các biến ID bên dưới.
4. Chọn **Run collection** và chạy cả hai thư mục theo đúng thứ tự, một lần lặp:
   - `01 - Happy flow (run in order)`: tạo giảng viên → tạo khóa học INACTIVE → cập nhật ACTIVE → tạo sinh viên → đăng ký khóa học.
   - `02 - Validation and missing records`: kiểm tra giảng viên không tồn tại (404), khóa học không tồn tại (404), email sai định dạng (400).

Có **8 request, 36 kiểm tra**. Các response đều được kiểm tra mã HTTP, `success`, `message` và `data = null`. Bốn request POST thành công còn kiểm tra header `Location`.

Các biến `instructorId`, `courseId`, `studentId`, `enrollmentId` được lấy tự động từ header `Location` và giữ dưới dạng chuỗi để tránh làm tròn số nguyên lớn trong JavaScript. Khi gửi JSON, biến ID được chèn dưới dạng số, không có dấu ngoặc kép. Request đầu tiên xóa ID của lần chạy trước.

Mỗi lần chạy thành công **để lại một giảng viên, một khóa học, một sinh viên và một lượt đăng ký** trong database. Ba request lỗi không tạo dữ liệu. Collection không có bước xóa dữ liệu và không cần endpoint GET; để xem bản ghi, dùng công cụ quản lý database. `Location` cung cấp ID cho bước tiếp theo, không có nghĩa bài này đã triển khai API GET tại URL đó.

Tài liệu tham khảo: [Biến trong Postman](https://learning.postman.com/docs/tests-and-scripts/write-scripts/postman-sandbox-reference/pm-variables/) và [viết kiểm tra response](https://learning.postman.com/docs/tests-and-scripts/write-scripts/test-scripts).
