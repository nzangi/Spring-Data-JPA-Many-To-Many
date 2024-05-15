package com.jpamanytomany.dto;

import com.jpamanytomany.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDTO {
    private int courseId;
    private String courseTitle;
    private String courseAbbreviation;
    private int courseModules;
    private double courseFee;
    private Set<StudentDTO> students;
}
