package com.sda;

import com.sda.entity.Dog;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main4FindEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog1 = session.find(Dog.class, 1L); // select
        if (dog1 != null) {
            System.out.println(dog1.getId());
            System.out.println(dog1.getName());
        }

        Dog dog2 = session.get(Dog.class, 2L); // select
        if (dog2 != null) {
            System.out.println(dog2.getId());
            System.out.println(dog2.getName());
        }

        try {
            Dog dog3 = session.load(Dog.class, 300L);
            System.out.println(dog3.getId());
            System.out.println(dog3.getName()); // select
        } catch (ObjectNotFoundException e) {
            System.out.println("Nie ma krotki o podanym id");
        }

        transaction.commit();
        session.close();

    }
}
