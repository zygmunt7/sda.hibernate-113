package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "husband")
@Getter
@Setter
@NoArgsConstructor
public class Husband {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Wife wife;

    public Husband(String name) {
        this.name = name;
    }
    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }
}
