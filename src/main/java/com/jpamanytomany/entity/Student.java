package com.jpamanytomany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jpamanytomany.dto.CourseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

//Student Table/Model Class

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Setter
@Getter
@Table(name = "student_table")
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private int studentAge;
    private String studentDepartment;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_table",
            joinColumns = {
                @JoinColumn(name = "student_id",referencedColumnName = "studentId")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "course_id",referencedColumnName = "courseId")
            }
    )

    @JsonManagedReference
    private List<Course> courses;

}
