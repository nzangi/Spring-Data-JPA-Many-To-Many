package com.jpamanytomany.mapper;

import com.jpamanytomany.dto.StudentDTO;
import com.jpamanytomany.entity.Student;

//Student Mapper
public class StudentMapper {
    public static Student mapToStudent(StudentDTO studentDTO){
        Student student = new Student(
                studentDTO.getStudentId(),
                studentDTO.getStudentName(),
                studentDTO.getStudentAge(),
                studentDTO.getStudentDepartment(),
                CourseMapper.mapToCourseSet(studentDTO.getCourses())
        );
        return student;
    }
    public static StudentDTO mapToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO(
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentAge(),
                student.getStudentDepartment(),
                CourseMapper.mapToCourseDTOSet(student.getCourses())
        );
        return studentDTO;
    }

}
