package com.hms.billing.service;

import com.hms.billing.model.Bill;
import com.hms.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BillingService {

    public void addBill(Bill bill) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(bill);
            transaction.commit();
            System.out.println("✅ Bill added for " + bill.getPatient());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Bill> getAllBills() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Bill", Bill.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
