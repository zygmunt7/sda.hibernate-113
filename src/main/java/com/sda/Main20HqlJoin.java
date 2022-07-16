package com.sda;

import com.sda.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.function.Consumer;

public class Main20HqlJoin {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Client> query = session.createQuery("SELECT c From Client c", Client.class);
        List<Client> result = query.getResultList();

        result.forEach(System.out::println);


        transaction.commit();
        session.close();
    }
}
