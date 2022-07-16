package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "school")
@NoArgsConstructor
@Getter
@ToString(exclude = "students")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "schools", fetch = FetchType.EAGER)   // mappedBy określa pole wg. którego będzie mapowana relacja (encja Student)
    Set<Student> students = new HashSet<>();                                                    // fetch określa, że wszystkie Encje z kolekcji student będą odrazu pobierane z bazy danych
    // domyślny FetchType dla @ManyToMany to LAZY

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {           // dodanie encji Student do kolekcji students nie zostanie odzwierciedlone w bazie danych
        student.addSchool(this);                        // gdyż to kolekcja schools w encji Student określa relację
        students.add(student);
    }
}
