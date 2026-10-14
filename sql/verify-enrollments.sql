-- Run in course_management_session04 after completing the five API requests.
SELECT e.id AS enrollment_id,
       s.id AS student_id, s.name AS student_name, s.email AS student_email,
       c.id AS course_id, c.title AS course_title, c.status AS course_status,
       i.id AS instructor_id, i.name AS instructor_name
FROM student_enrollments e
JOIN students s ON s.id = e.student_id
JOIN courses c ON c.id = e.course_id
JOIN instructors i ON i.id = c.instructor_id
ORDER BY e.id DESC;
