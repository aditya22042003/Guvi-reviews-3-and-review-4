public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean registerUser(User user) {
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return false;
        }
        return userDAO.save(user);
    }
}
