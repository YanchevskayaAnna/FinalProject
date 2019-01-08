package services.interfaces;

import model.User;

import java.util.List;

public interface IUserService {
    String getHash(String password);
    List<User> getAllUsers();
    User getUserId(Integer id);
    User getUser(String login, String password);
    boolean updateUser(User user);
    boolean createUser(User user);
    boolean deleteUser(User user);
    boolean deleteUserById(Integer id);
}
