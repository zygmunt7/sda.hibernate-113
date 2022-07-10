package com.sda;

import com.sda.entity.Bird;
import com.sda.entity.Book;
import com.sda.entity.Cat;
import com.sda.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main14MenyToOne {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = new Client("Andrzej");

        client.addBook(new Book("Harry Potter"));
        client.addBook(new Book("Ogniem i mieczem"));
        client.addBook(new Book("Alicja w krainie czarów"));

        session.persist(client);

        transaction.commit();
        session.close();
    }
}
