import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.mockito.Mockito.*;

public class UserDAOTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Test
    public void testSave_Success() throws Exception {
        MockitoAnnotations.openMocks(this);
        UserDAO userDAO = new UserDAO(connection);
        User user = new User("Jane Doe", "jane@example.com", "securePassword");

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        boolean result = userDAO.save(user);

        assertTrue(result);
        verify(connection, times(1)).prepareStatement(anyString());
        verify(preparedStatement, times(1)).executeUpdate();
    }
}
