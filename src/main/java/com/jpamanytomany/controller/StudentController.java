package com.jpamanytomany.controller;

import com.jpamanytomany.entity.Student;
import com.jpamanytomany.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
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
    public Optional<Student> getStudent(@PathVariable Integer studentId){
        return studentService.getStudent(studentId);
    }

}
