import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterUser_ValidInput() throws Exception {
        String userJson = "{\"name\": \"John\", \"email\": \"john@example.com\", \"password\": \"123456\"}";

        mockMvc.perform(post("/api/users/register")
                .contentType("application/json")
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully."));
    }

    @Test
    public void testRegisterUser_InvalidEmail() throws Exception {
        String userJson = "{\"name\": \"John\", \"email\": \"invalid-email\", \"password\": \"123456\"}";

        mockMvc.perform(post("/api/users/register")
                .contentType("application/json")
                .content(userJson))
                .andExpect(status().isBadRequest());
    }
}
