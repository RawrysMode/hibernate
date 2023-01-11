package com.rawrysmode.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
//                        .addAnnotatedClass(City.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Something went wrong with SessionFactory: " + e);
            }
        }
        return sessionFactory;
    }

}
