package com.hms.prescription.service;

import com.hms.prescription.model.Prescription;
import com.hms.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PrescriptionService {

    public List<Prescription> getPrescriptionsByPatient(String patientUsername) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Prescription WHERE patient = :patient", Prescription.class)
                    .setParameter("patient", patientUsername)
                    .list();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
