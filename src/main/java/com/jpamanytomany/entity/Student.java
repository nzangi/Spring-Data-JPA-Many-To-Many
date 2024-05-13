package com.jpamanytomany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Set<Course> courses;

}
