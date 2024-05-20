package com.jpamanytomany.service.implementation;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.entity.Course;
import com.jpamanytomany.mapper.CourseMapper;
import com.jpamanytomany.repository.CourseRepository;
import com.jpamanytomany.repository.StudentRepository;
import com.jpamanytomany.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplementation implements CourseService {
    private CourseRepository courseRepository;
    public CourseServiceImplementation(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    // get all students
    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    // get course whose fee is less than entered amount
    public List<CourseDTO> getCourseLessThan(double coursePrice){
        List<Course> courses = courseRepository.findByCourseFeeLessThan(coursePrice);
        return courses.stream().map(CourseMapper::mapToCourseDTO).collect(Collectors.toList());
    }
}
