package dao.SQLDao;

import dao.interfaces.IBonusDAO;
import dao.interfaces.IClientDAO;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLBonusDAO extends SQLDao<Bonus, Integer> implements IBonusDAO {

    public SQLBonusDAO(Connection connection) {
        super(Bonus.class, Integer.class, connection);
    }

    @Override
    public List<Bonus> getAll() {

        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bonuses;");) {
            List<Bonus> bonusList = getAllBonusesFromResultSet(resultSet);
            return bonusList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Bonus> getAllBonusesFromResultSet(ResultSet resultSet) throws SQLException {

        List<Bonus> bonusList = new ArrayList<>();
        while (resultSet.next()) {
            Bonus bonus = new Bonus();
            bonus.setId(resultSet.getInt("id"));
            bonus.setName(resultSet.getString("bonus_name"));
            bonus.setPrice(resultSet.getInt("bonus_price"));
            bonusList.add(bonus);
        }
        return bonusList;
    }

    @Override
    public boolean update(Bonus entity) {

        String sqlQuery = "UPDATE bonuses SET bonus_name=?, bonus_price=?  WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getPrice());
            preparedStatement.setInt(3, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Bonus entity) {
        String sqlQuery = "INSERT INTO bonuses (bonus_name, bonus_price) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Bonus entity) {
        String sqlQuery = "DELETE FROM bonuses WHERE id = ?";

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
    public List<Bonus> defineBonuses(int idClient, int idCruise) {
        String sqlQuery =
                "SELECT * FROM bonuses INNER JOIN ticketbonuses " +
                                        "ON bonuses.id = ticketbonuses.ticketbonuses_idBonus " +
                                                    "INNER JOIN tickets ON ticketbonuses.ticketbonuses_idTicket = tickets.id  AND tickets.ticket_idclient = ? AND tickets.ticket_idcruise = ? ";


        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, idClient);
            preparedStatement.setInt(2, idCruise);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Bonus> bonusList = getAllBonusesFromResultSet(resultSet);
            return bonusList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
