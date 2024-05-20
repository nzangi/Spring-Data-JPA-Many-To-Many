package com.jpamanytomany.mapper;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.entity.Course;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//Course Mapper
public class CourseMapper {
    public static Course mapToCourse(CourseDTO courseDTO){
        Course course = new Course(
                courseDTO.getCourseId(),
                courseDTO.getCourseTitle(),
                courseDTO.getCourseAbbreviation(),
                courseDTO.getCourseModules(),
                courseDTO.getCourseFee(),
                null
//                StudentMapper.mapToStudentList(courseDTO.getStudents())

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
                null
//                StudentMapper.mapToStudentDTOList(course.getStudents())

        );

        return courseDTO;
    }

    public static List<Course> mapToCourseList(List<CourseDTO> courseDTOs) {
        return courseDTOs.stream()
                .map(CourseMapper::mapToCourse)
                .collect(Collectors.toList());
    }

    public static List<CourseDTO> mapToCourseDTOList(List<Course> courses){
        return courses.stream().map(CourseMapper::mapToCourseDTO).collect(Collectors.toList());
    }

}
