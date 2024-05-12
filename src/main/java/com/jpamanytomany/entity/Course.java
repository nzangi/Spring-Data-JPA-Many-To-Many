package com.jpamanytomany.entity;

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
@Table(name = "course_table")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseTitle;
    private String courseAbbreviation;
    private int courseModules;
    private double couseFee;

    @ManyToMany(mappedBy = "C" +
            "ourse",fetch = FetchType.LAZY)
    private Set<Student> students;

}
