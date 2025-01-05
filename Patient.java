import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Patient {

    @NotBlank(message = "Name is required.")
    private String name;

    @Min(value = 1, message = "Age must be greater than 0.")
    private int age;

    @NotBlank(message = "Contact is required.")
    private String contact;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
