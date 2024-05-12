package com.jpamanytomany.repository;

import com.jpamanytomany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findByCouseFeeLessThan(double courseFee);
}
