package com.sda.entity;


import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name; // Ogniem i mieczem
    @ManyToOne
    Client client;

    public Book(String name) {
        this.name = name;
    }
}
