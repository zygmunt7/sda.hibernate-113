package com.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // todo ....

        transaction.commit();
        session.close();

    }
}
