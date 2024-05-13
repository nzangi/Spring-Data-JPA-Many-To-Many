package com.jpamanytomany.repository;

import com.jpamanytomany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findByCourseFeeLessThan(double courseFee);
}
