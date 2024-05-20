package com.jpamanytomany.service;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> findAllCourses();
    List<CourseDTO> getCourseLessThan(double coursePrice );

}
