package com.jpamanytomany.mapper;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.dto.StudentDTO;
import com.jpamanytomany.entity.Course;
import com.jpamanytomany.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

//Student Mapper
public class StudentMapper {
    public static Student mapToStudent(StudentDTO studentDTO){
        Student student = new Student(
                studentDTO.getStudentId(),
                studentDTO.getStudentName(),
                studentDTO.getStudentAge(),
                studentDTO.getStudentDepartment(),
                CourseMapper.mapToCourseList(studentDTO.getCourses())
        );
        return student;
    }
    public static StudentDTO mapToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO(
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentAge(),
                student.getStudentDepartment(),
                CourseMapper.mapToCourseDTOList(student.getCourses())
        );
        return studentDTO;
    }

    public static List<Student> mapToStudentList(List<StudentDTO> studentDTOs) {
        return studentDTOs.stream()
                .map(StudentMapper::mapToStudent)
                .collect(Collectors.toList());
    }

    public static List<StudentDTO> mapToStudentDTOList(List<Student> students){
        return students.stream().map(StudentMapper::mapToStudentDTO).collect(Collectors.toList());
    }

}
