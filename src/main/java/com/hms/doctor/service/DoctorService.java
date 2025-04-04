package com.hms.doctor.service;

import com.hms.doctor.model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.ArrayList;

public class DoctorService {

    // Build the SessionFactory from hibernate.cfg.xml.
    // In production, you might want to manage this via dependency injection or a singleton pattern.
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    /**
     * Adds a new doctor to the remote database.
     * Note: The Doctor entity now includes a 'password' field that will be persisted.
     *
     * @param doctor the Doctor object to add.
     * @return true if the operation was successful, false otherwise.
     */
    public boolean addDoctor(Doctor doctor) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(doctor);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves a Doctor from the database by username.
     * The returned Doctor object will include the password field.
     *
     * @param username the doctor's username.
     * @return the Doctor if found, or null otherwise.
     */
    public Doctor getDoctorByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Doctor.class, username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Updates an existing Doctor in the database.
     * The update will include changes to the password field if modified.
     *
     * @param doctor the Doctor object with updated details.
     * @return true if the update was successful, false otherwise.
     */
    public boolean updateDoctor(Doctor doctor) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(doctor);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Simulates prescribing medication for a doctor.
     * In a real application, this might involve inserting into a prescriptions table.
     *
     * @param username the doctor's username.
     * @param medication the medication name.
     * @param dosage the dosage information.
     * @param instructions any additional instructions.
     */
    public void prescribeMedication(String username, String medication, String dosage, String instructions) {
        System.out.println("Prescribed " + medication + " (" + dosage + ") to doctor " + username +
                ". Instructions: " + instructions);
    }

    /**
     * Retrieves assigned patient record summaries for a doctor.
     * This is a dummy implementation for demonstration.
     *
     * @param doctorUsername the doctor's username.
     * @return a list of patient record summaries.
     */
    public List<String> getAssignedPatientRecords(String doctorUsername) {
        List<String> records = new ArrayList<>();
        records.add("Patient Record 1 for " + doctorUsername);
        records.add("Patient Record 2 for " + doctorUsername);
        return records;
    }

    /**
     * Retrieves all doctors from the database.
     * The returned list will include the password field as well.
     *
     * @return a List of Doctor objects.
     */
    public List<Doctor> getAllDoctors() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Doctor", Doctor.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
