import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private final List<Patient> patientList = new ArrayList<>();

    // Register a new patient
    public Patient registerPatient(Patient patient) {
        patientList.add(patient);
        return patient;
    }

    // Retrieve all patients
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientList);
    }
}
