package com.healthcare.dao;

import com.healthcare.model.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientDAOTest {

    @Test
    void testAddPatient() {
        PatientDAO patientDAO = new PatientDAO();
        Patient patient = new Patient(1, "John Doe", 30);
        assertTrue(patientDAO.addPatient(patient));
    }

    @Test
    void testGetPatientById() {
        PatientDAO patientDAO = new PatientDAO();
        Patient patient = new Patient(1, "John Doe", 30);
        patientDAO.addPatient(patient);

        Patient retrievedPatient = patientDAO.getPatientById(1);
        assertNotNull(retrievedPatient);
        assertEquals("John Doe", retrievedPatient.getName());
    }

    @Test
    void testGetAllPatients() {
        PatientDAO patientDAO = new PatientDAO();
        patientDAO.addPatient(new Patient(1, "John Doe", 30));
        patientDAO.addPatient(new Patient(2, "Jane Smith", 25));

        assertEquals(2, patientDAO.getAllPatients().size());
    }
}
