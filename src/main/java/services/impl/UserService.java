package services.impl;

import dao.interfaces.IUserDAO;
import model.User;
import services.interfaces.IUserService;

import java.util.List;
import java.util.Objects;

public class UserService implements IUserService {
    private IUserDAO userDAO;

    public UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String getHash(String password) {
        return CryptWithMD5.cryptWithMD5(password);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @Override
    public User getUserId(Integer id) {
        return userDAO.getById(id);
    }

    @Override
    public User getUser(String login, String password) {
        return userDAO.getUser(login, password);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean createUser(User user) {
        return userDAO.create(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return userDAO.delete(user);
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return userDAO.deleteById(id);
    }

}
