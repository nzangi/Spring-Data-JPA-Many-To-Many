package com.jpamanytomany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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
    private List<CourseDTO> courses;
}
