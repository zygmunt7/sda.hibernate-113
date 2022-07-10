package com.sda.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    Set<Book> books = new HashSet<>();

    public Client(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setClient(this);
    }
}
