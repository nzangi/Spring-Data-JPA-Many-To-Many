package com.jpamanytomany.controller;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.dto.StudentDTO;
import com.jpamanytomany.entity.Student;
import com.jpamanytomany.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    //private StudentService studentService;
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //save student course controller
    @PostMapping
    public ResponseEntity<StudentDTO> saveStudentWithCourse(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.saveStudentWithCourse(studentDTO), HttpStatus.CREATED);
    }

    //get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    // get student by Id
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer studentId){
        return new ResponseEntity<>(studentService.getStudent(studentId),HttpStatus.OK);
    }

    //Get all students with a name
    @GetMapping("/find/{studentName}")
    public ResponseEntity<List<StudentDTO>> getStudentsWithName(@PathVariable String studentName){
        return new ResponseEntity<>(studentService.getStudentsWithName(studentName),HttpStatus.OK);
    }

    //get course with fee less than
    @GetMapping("/search/{courseName}")
    public ResponseEntity<List<CourseDTO>> getCourseWithFeeLess(@PathVariable double courseName){
        return new ResponseEntity<>(studentService.getCourseLessThan(courseName),HttpStatus.OK);
    }

}
