package com.hms;

import com.hms.util.HibernateUtil;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("✅ Hibernate Connected Successfully!");
        session.close();
    }
}