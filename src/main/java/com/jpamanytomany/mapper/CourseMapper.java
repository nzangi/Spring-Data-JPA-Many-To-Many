package com.jpamanytomany.mapper;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.entity.Course;

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
        );

        return courseDTO;
    }
    public static Set<Course> mapToCourseSet(Set<CourseDTO> courseDTOs) {
        return courseDTOs.stream()
                .map(CourseMapper::mapToCourse)
                .collect(Collectors.toSet());
    }

    public static Set<CourseDTO> mapToCourseDTOSet(Set<Course> courses){
        return courses.stream().map(CourseMapper::mapToCourseDTO).collect(Collectors.toSet());
    }

}
