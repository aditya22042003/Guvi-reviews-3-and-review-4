import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDAO);
    }

    @Test
    public void testRegisterUser_Success() {
        User user = new User("John Doe", "john@example.com", "password123");
        when(userDAO.save(user)).thenReturn(true);

        boolean result = userService.registerUser(user);

        assertTrue(result);
        verify(userDAO, times(1)).save(user);
    }

    @Test
    public void testRegisterUser_Failure_NullName() {
        User user = new User(null, "john@example.com", "password123");

        boolean result = userService.registerUser(user);

        assertFalse(result);
        verify(userDAO, never()).save(any(User.class));
    }
}
