package com.jpamanytomany.service;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.dto.StudentDTO;
import com.jpamanytomany.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    StudentDTO saveStudentWithCourse(StudentDTO studentDTO);
    List<Student> getAllStudents();
    StudentDTO getStudent(Integer studentId);
    List<StudentDTO> getStudentsWithName(String studentName);
    List<CourseDTO> getCourseLessThan(double coursePrice );

}
