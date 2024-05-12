package com.jpamanytomany.repository;

import com.jpamanytomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByStudentNameContaining(String studentName);
}
