package com.rawrysmode.utils;

import com.rawrysmode.entities.bank_detail.BankDetail;
import com.rawrysmode.entities.city.City;
import com.rawrysmode.entities.client.Client;
import com.rawrysmode.entities.employee.Employee;
import com.rawrysmode.entities.employee_transfer.EmployeeTransfer;
import com.rawrysmode.entities.job.Job;
import com.rawrysmode.entities.order.Order;
import com.rawrysmode.entities.order_wagon_place.OrderWagonPlace;
import com.rawrysmode.entities.route.Route;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .addAnnotatedClass(City.class)
                        .addAnnotatedClass(Route.class)
                        .addAnnotatedClass(Client.class)
                        .addAnnotatedClass(BankDetail.class)
                        .addAnnotatedClass(Job.class)
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Order.class)
                        .addAnnotatedClass(EmployeeTransfer.class)
                        .addAnnotatedClass(OrderWagonPlace.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Something went wrong with SessionFactory: " + e);
            }
        }
        return sessionFactory;
    }

}
