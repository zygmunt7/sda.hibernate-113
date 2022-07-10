package com.sda.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany
    @JoinTable(
            name = "student_school",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "school_id")
    )
    Set<School> schools = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public void addSchool(School school) {
        this.schools.add(school);
    }
}
