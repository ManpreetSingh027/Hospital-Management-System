package com.hms.patient.util;

import com.hms.patient.model.Patient;

public class PatientSession {
    private static Patient loggedInPatient;

    public static void setLoggedInPatient(Patient patient) {
        loggedInPatient = patient;
    }

    public static Patient getLoggedInPatient() {
        return loggedInPatient;
    }
}
