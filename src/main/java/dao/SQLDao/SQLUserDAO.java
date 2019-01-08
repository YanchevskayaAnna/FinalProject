package dao.SQLDao;

import dao.interfaces.IUserDAO;
import model.Excursion;
import model.User;
import model.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLUserDAO extends SQLDao<User, Integer> implements IUserDAO {

    public SQLUserDAO(Connection connection) {
        super(User.class, Integer.class, connection);
    }

    @Override
    public List<User> getAll() {

        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            List<User> userList = getAllUsersFromResultSet(resultSet);
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<User> getAllUsersFromResultSet(ResultSet resultSet) throws SQLException {

        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("user_name"));
            user.setPhone(resultSet.getString("user_phone"));
            user.setEmail(resultSet.getString("user_email"));
            user.setPassword(resultSet.getString("user_password"));
            user.setRole(UserRole.valueOf(resultSet.getString("user_role")));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public boolean update(User entity) {

        String sqlQuery = "UPDATE users SET user_name=?, user_mail=?, user_phone=?, user_role=?, user_password=?  WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getPhone());
            preparedStatement.setString(4, entity.getRole().name());
            preparedStatement.setString(5, entity.getPassword());
            preparedStatement.setInt(6, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(User entity) {
        String sqlQuery = "INSERT INTO users (user_name, user_email, user_phone, user_role, user_password) VALUES (?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getPhone());
            preparedStatement.setString(4, entity.getRole().name());
            preparedStatement.setString(5, entity.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(User entity) {
        String sqlQuery = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public User getUser(String login, String password) {
        String sqlQuery = "SELECT * FROM users WHERE users.user_email = ? & users.user_password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = getAllUsersFromResultSet(resultSet);
            return userList.size() > 0 ? userList.get(0) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Excursion, Boolean> defineExcursions(int idUser, int idCruise) {
        String sqlQuery = "SELECT excursions.*, excursions_tickets.id idTicket FROM excursions INNER JOIN cruise_routs ON excursions.excursion_id_port = cruise_routs.cruiserout_idport AND cruise_routs.cruiserout_idcruise = ?" +
                "LEFT JOIN excursions_tickets ON excursions.id = excursions_tickets.excursionticket_idExcursion AND excursions_tickets.excursionticket_idclient = ?";

        Map<Excursion, Boolean> excursionMap = new HashMap<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, idCruise);
            preparedStatement.setInt(2, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Excursion excursion = new Excursion();
                excursion.setId(resultSet.getInt("id"));
                excursion.setName(resultSet.getString("excursion_name"));
                excursion.setPrice(resultSet.getInt("excursion_price"));
                excursion.setIdPort(resultSet.getInt("excursion_id_port"));
                Integer excursionPaid = resultSet.getInt("idTicket");
                excursionMap.put(excursion, excursionPaid != null);
            }
            return excursionMap;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
