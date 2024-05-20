package com.jpamanytomany.controller;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.entity.Course;
import com.jpamanytomany.entity.Student;
import com.jpamanytomany.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    //DI
    private CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    // get all courses
    @GetMapping
    public ResponseEntity<List<Course>> findAllCourses(){
        return new ResponseEntity<>(courseService.findAllCourses(),HttpStatus.OK);
    }

    //get course with fee less than
    @GetMapping("/search/{courseName}")
    public ResponseEntity<List<CourseDTO>> findCourseWithFeeLess(@PathVariable double courseName){
        return new ResponseEntity<>(courseService.getCourseLessThan(courseName), HttpStatus.OK);
    }
}
