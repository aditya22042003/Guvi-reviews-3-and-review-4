package com.healthcare.dao;

import com.healthcare.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private final List<Patient> patients = new ArrayList<>();

    public boolean addPatient(Patient patient) {
        return patients.add(patient);
    }

    public Patient getPatientById(int id) {
        return patients.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }
}
