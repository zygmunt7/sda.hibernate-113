package com.sda;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5UpdateEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog1 = session.find(Dog.class, 1L);
        dog1.setAge(14);

        Dog dog2 = new Dog();
        dog2.setId(2L);
        dog2.setName("Sonia");
        dog2.setAge(11);
        dog2.setRace("Buldog");
        session.update(dog2);
        
        Dog d =new Dog();
        session.merge(d);
        d.setAge(10);

        transaction.commit();
        session.close();

    }
}
