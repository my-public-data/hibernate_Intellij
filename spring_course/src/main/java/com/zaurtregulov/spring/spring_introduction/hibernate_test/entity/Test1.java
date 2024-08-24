package com.zaurtregulov.spring.spring_introduction.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        //1) Создаем SessionFactory factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        //2) Получаем сессию из SessionFactory factory
        Session session = factory.getCurrentSession();
        //3) Создаем объект класса
        Employee emp = new Employee("Zaur", "Tregulov", "IT", 500);

        try {
        //4) Начинаем транзакцию
            session.beginTransaction();
        //5) Сохраняем объект (происходит Insert)
            session.save(emp);
        //6) Закрываем транзакцию коммитом или роллбэком - если хотим откатитьь Insert из этой строки
            session.getTransaction().commit();

        } finally {
        //7Закрываем SessionFactory factory
            factory.close();
        }

    }
}
