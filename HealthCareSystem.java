import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Main Class
public class HealthCareSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}

// Main Menu
class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Healthcare System");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton btnRegister = new JButton("Register Patient");
        JButton btnView = new JButton("View Patients");
        JButton btnBook = new JButton("Book Appointment");

        btnRegister.addActionListener(e -> new PatientForm().setVisible(true));
        btnView.addActionListener(e -> new PatientList().setVisible(true));
        btnBook.addActionListener(e -> new AppointmentForm().setVisible(true));

        panel.add(btnRegister);
        panel.add(btnView);
        panel.add(btnBook);
        add(panel);
    }
}

// Patient Form
class PatientForm extends JFrame {
    private JTextField nameField, ageField, contactField;

    public PatientForm() {
        setTitle("Register Patient");
        setSize(300, 200);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        nameField = new JTextField();
        ageField = new JTextField();
        contactField = new JTextField();
        JButton btnRegister = new JButton("Register");

        btnRegister.addActionListener(e -> {
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String contact = contactField.getText().trim();
            if (name.isEmpty() || ageText.isEmpty() || contact.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                int age = Integer.parseInt(ageText);
                if (age <= 0) throw new NumberFormatException();
                PatientData.addPatient(new Patient(name, age, contact));
                JOptionPane.showMessageDialog(this, "Patient registered successfully!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Contact:"));
        panel.add(contactField);
        panel.add(new JLabel());
        panel.add(btnRegister);
        add(panel);
    }
}

// Patient List
class PatientList extends JFrame {
    public PatientList() {
        setTitle("Patient List");
        setSize(400, 300);
        setLocationRelativeTo(null);
        JTextArea textArea = new JTextArea(15, 30);
        textArea.setEditable(false);

        StringBuilder sb = new StringBuilder("Registered Patients:\n");
        for (Patient patient : PatientData.getPatients()) {
            sb.append("Name: ").append(patient.getName())
              .append(", Age: ").append(patient.getAge())
              .append(", Contact: ").append(patient.getContact()).append("\n");
        }
        textArea.setText(sb.toString());
        add(new JScrollPane(textArea));
    }
}

// Appointment Form
class AppointmentForm extends JFrame {
    public AppointmentForm() {
        setTitle("Book Appointment");
        setSize(300, 200);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JTextField nameField = new JTextField();
        JTextField doctorField = new JTextField();
        JTextField dateField = new JTextField();
        JButton btnBook = new JButton("Book");

        btnBook.addActionListener(e -> {
            if (nameField.getText().isEmpty() || doctorField.getText().isEmpty() || dateField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Appointment booked successfully!");
                dispose();
            }
        });

        panel.add(new JLabel("Patient Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Doctor:"));
        panel.add(doctorField);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        panel.add(new JLabel());
        panel.add(btnBook);
        add(panel);
    }
}

// Model: Patient
class Patient {
    private String name;
    private int age;
    private String contact;

    public Patient(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContact() { return contact; }
}

// Data Storage
class PatientData {
    private static final List<Patient> patients = new ArrayList<>();
    public static void addPatient(Patient patient) { patients.add(patient); }
    public static List<Patient> getPatients() { return patients; }
}
