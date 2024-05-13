package com.jpamanytomany.controller;

import com.jpamanytomany.entity.Course;
import com.jpamanytomany.entity.Student;
import com.jpamanytomany.repository.CourseRepository;
import com.jpamanytomany.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-course")
public class StudentController {

    /*
    * Create USe of Account Mapper
    * Use of Response Body and Exception handling
    *
    * */

    //Constructor Dependency Injection
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    //save student course controller
    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student){
        return studentService.saveStudentWithCourse(student);
    }

    //get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    // get student by Id
    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        return studentService.getStudent(studentId);
    }
    //Get all students with a name
    @GetMapping("/find/{studentName}")
    public List<Student> getStudentsWithName(@PathVariable String studentName){
        return studentService.getStudentsWithName(studentName);
    }
    //get course with fee less than
    @GetMapping("/search/{courseName}")
    public List<Course> getCourseWithFeeLess(@PathVariable double courseName){
        return studentService.getCourseLessThan(courseName);
    }

}
