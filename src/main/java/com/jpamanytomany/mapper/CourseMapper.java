package com.jpamanytomany.mapper;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.dto.StudentDTO;
import com.jpamanytomany.entity.Course;
import com.jpamanytomany.entity.Student;

public class CourseMapper {
    public static Course mapToCourse(CourseDTO courseDTO){
        Course course = new Course(
                courseDTO.getCourseId(),
                courseDTO.getCourseTitle(),
                courseDTO.getCourseAbbreviation(),
                courseDTO.getCourseModules(),
                courseDTO.getCourseFee(),
                courseDTO.getStudents()
        );
        return course;
    }
    public static CourseDTO mapToCourseDTO(Course course){
        CourseDTO courseDTO = new CourseDTO(
                course.getCourseId(),
                course.getCourseTitle(),
                course.getCourseAbbreviation(),
                course.getCourseModules(),
                course.getCourseFee(),
                course.getStudents()
        );
        return courseDTO;
    }
}
