package com.hms.doctor.data;

import com.hms.doctor.model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorData {
    // Static list to hold doctor records
    private static List<Doctor> doctorList = new ArrayList<>();

    public static List<Doctor> getDoctorList() {
        return doctorList;
    }

    public static void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }
}
