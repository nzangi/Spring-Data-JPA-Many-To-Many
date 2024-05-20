package com.jpamanytomany.service;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.dto.StudentDTO;
import com.jpamanytomany.entity.Course;
import com.jpamanytomany.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    StudentDTO saveStudentWithCourse(StudentDTO studentDTO);
    List<Student> findAllStudents();
    StudentDTO findStudent(Integer studentId);
    List<StudentDTO> findStudentsWithName(String studentName);


}
