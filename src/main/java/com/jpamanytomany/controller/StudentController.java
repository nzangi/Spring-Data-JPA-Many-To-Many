package com.jpamanytomany.controller;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.dto.StudentDTO;
import com.jpamanytomany.entity.Course;
import com.jpamanytomany.entity.Student;
import com.jpamanytomany.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-course")
public class StudentController {

    /*
    * Create Use of Account Mapper
    * Create A DTO
    * Create StudentDTO Service interface for StudentDTO Service Implementation
    * Use of Response Body and Exception handling
    *
    */

    //Constructor Dependency Injection
//    private StudentService studentService;
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    //save student course controller
    @PostMapping
    public StudentDTO saveStudentWithCourse(@RequestBody StudentDTO studentDTO){
        return studentService.saveStudentWithCourse(studentDTO);
    }

    //get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // get student by Id
    @GetMapping("/{studentId}")
    public StudentDTO getStudent(@PathVariable Integer studentId){
        return studentService.getStudent(studentId);
    }

    //Get all students with a name
    @GetMapping("/find/{studentName}")
    public List<StudentDTO> getStudentsWithName(@PathVariable String studentName){
        return studentService.getStudentsWithName(studentName);
    }
    //get course with fee less than
    @GetMapping("/search/{courseName}")
    public List<CourseDTO> getCourseWithFeeLess(@PathVariable double courseName){
        return studentService.getCourseLessThan(courseName);
    }

}
