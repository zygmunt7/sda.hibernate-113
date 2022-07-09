package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_table")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable = false)
    String name;
    @Column(name = "password")
    String secret;
    @Column(length = 9, unique = true)
    String telephoneNumber;   //telephone_number
    @Transient
    Long age;
    @Temporal(TemporalType.DATE)
    Date birtDate;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Lob
    String description;

    public Employee(String name, String secret, String telephoneNumber, Long age, Date birtDate, Gender gender, String description) {
        this.name = name;
        this.secret = secret;
        this.telephoneNumber = telephoneNumber;
        this.age = age;
        this.birtDate = birtDate;
        this.gender = gender;
        this.description = description;
    }
}
