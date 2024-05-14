package com.jpamanytomany.dto;

import com.jpamanytomany.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StudentDTO {
    private int studentId;
    private String studentName;
    private int studentAge;
    private String studentDepartment;
    private Set<Course> courses;
}
