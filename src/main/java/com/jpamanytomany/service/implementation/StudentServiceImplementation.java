package com.jpamanytomany.service.implementation;

import com.jpamanytomany.dto.CourseDTO;
import com.jpamanytomany.dto.StudentDTO;
import com.jpamanytomany.entity.Course;
import com.jpamanytomany.entity.Student;
import com.jpamanytomany.exception.RunTimeExceptionError;
import com.jpamanytomany.mapper.CourseMapper;
import com.jpamanytomany.mapper.StudentMapper;
import com.jpamanytomany.repository.CourseRepository;
import com.jpamanytomany.repository.StudentRepository;
import com.jpamanytomany.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class StudentServiceImplementation implements StudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    // constructor injection
    public StudentServiceImplementation(StudentRepository studentRepository,
                                        CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository=courseRepository;

    }

    // save student with course name
    public StudentDTO saveStudentWithCourse(StudentDTO studentDTO){
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student studentSaved =studentRepository.save(student);
        return StudentMapper.mapToStudentDTO(studentSaved);
    }

    // get all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //  get student by name service
    public StudentDTO getStudent(Integer studentId){
        Student student= studentRepository.findById(studentId).orElseThrow(
                () -> new RunTimeExceptionError("StudentDTO Id "+ studentId + " does not exists")
        );
        return StudentMapper.mapToStudentDTO(student);
    }

    // get all student with a certain name
    public List<StudentDTO> getStudentsWithName(String studentName){
        List<Student> students = studentRepository.findByStudentNameContaining(studentName);
        return students.stream().map(StudentMapper::mapToStudentDTO).collect(Collectors.toList());
    }

    // get course whose fee is less than entered amount
    public List<CourseDTO> getCourseLessThan(double coursePrice){
        List<Course> courses = courseRepository.findByCourseFeeLessThan(coursePrice);
        return courses.stream().map(CourseMapper::mapToCourseDTO).collect(Collectors.toList());
    }
}
