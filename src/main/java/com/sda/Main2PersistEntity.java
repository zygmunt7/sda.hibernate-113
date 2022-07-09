package com.sda;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2PersistEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog("", 10, "");

        session.persist(new Dog("Ares", 10, "Terier"));
        session.persist(new Dog("Berlin", 3, "Szpic"));
        session.persist(new Dog("Cezar", 8, "Kundel;"));
        session.persist(new Dog("Diego", 12, "Owczarek"));
        session.persist(new Dog("Pimpek", 12, "Jamnik"));
        session.persist(new Dog("Benek", 5, "Bulterier"));


        transaction.commit();
        session.close();

    }
}
