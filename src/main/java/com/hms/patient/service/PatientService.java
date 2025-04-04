package com.hms.patient.service;

import com.hms.patient.model.Patient;
import com.hms.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatientService {

    public Patient getPatientByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Patient WHERE username = :username", Patient.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updatePatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Method for patient registration
    public boolean registerPatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Check if a patient with the given username already exists
            Patient existing = session.createQuery("FROM Patient WHERE username = :username", Patient.class)
                    .setParameter("username", patient.getUsername())
                    .uniqueResult();
            if(existing != null) {
                return false; // Registration fails if username is already taken
            }

            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
            return true;
        } catch(Exception e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
    // Retrieve all patients from the database
    public List<Patient> getAllPatients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Patient", Patient.class).list();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
