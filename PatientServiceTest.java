import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PatientServiceTest {

    private final PatientService patientService = new PatientService();

    @Test
    public void testRegisterPatient() {
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setAge(30);
        patient.setContact("1234567890");

        Patient savedPatient = patientService.registerPatient(patient);
        assertNotNull(savedPatient);
        assertEquals("John Doe", savedPatient.getName());
    }

    @Test
    public void testGetAllPatients() {
        Patient patient1 = new Patient();
        patient1.setName("Alice");
        patient1.setAge(25);
        patient1.setContact("9876543210");

        patientService.registerPatient(patient1);

        List<Patient> patients = patientService.getAllPatients();
        assertEquals(1, patients.size());
        assertEquals("Alice", patients.get(0).getName());
    }
}
