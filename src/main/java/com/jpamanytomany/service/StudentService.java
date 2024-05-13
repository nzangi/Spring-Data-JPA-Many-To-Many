package com.jpamanytomany.service;

import com.jpamanytomany.entity.Student;
import com.jpamanytomany.repository.CourseRepository;
import com.jpamanytomany.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    // constructor injection
    public StudentService(StudentRepository studentRepository,
                          CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository=courseRepository;

    }
    // save student with course name
    public Student saveStudentWithCourse(Student student){
        return studentRepository.save(student);
    }
    // get all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
   //  get student by name

   public Optional<Student> getStudent(Integer studentId){
        return studentRepository.findById(studentId);
   }

}
