package com.hms.appointment.service;

import com.hms.appointment.model.Appointment;
import com.hms.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    // Persist a new appointment
    public void scheduleAppointment(Appointment appointment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
            System.out.println("Scheduled Appointment: " + appointment);
        } catch(Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Retrieve appointments for a specific patient
    public List<Appointment> getAppointmentsByPatient(String patientUsername) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Appointment WHERE patient = :patient", Appointment.class)
                    .setParameter("patient", patientUsername)
                    .list();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Appointment> getAppointmentsByDoctor(String doctorUsername) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Appointment> list = session.createQuery("FROM Appointment WHERE doctor = :doctor", Appointment.class)
                    .setParameter("doctor", doctorUsername)
                    .list();
            return list != null ? list : new ArrayList<>();
        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public boolean updateAppointment(Appointment appointment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(appointment);
            transaction.commit();
            System.out.println("Updated appointment: " + appointment);
            return true;
        } catch(Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
