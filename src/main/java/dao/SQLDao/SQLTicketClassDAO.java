package dao.SQLDao;

import dao.interfaces.ITicketClassDAO;
import model.TicketClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLTicketClassDAO extends SQLDao<TicketClass, Integer> implements ITicketClassDAO {

    public SQLTicketClassDAO(Connection connection) {
        super(TicketClass.class, Integer.class, connection);
    }

    @Override
    public List<TicketClass> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ticketclases;");) {
            List<TicketClass> ticketClassList  = getAllTicketClassesFromResultSet(resultSet);
            return ticketClassList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<TicketClass> getAllTicketClassesFromResultSet(ResultSet resultSet) throws SQLException {

        List<TicketClass> ticketClassList = new ArrayList<>();
        while (resultSet.next()) {
            TicketClass ticketClass = new TicketClass();
            ticketClass.setId(resultSet.getInt("id"));
            ticketClass.setLevelComfort(resultSet.getInt("ticketclass_level"));
            ticketClassList.add(ticketClass);
        }
        return ticketClassList;
    }

    @Override
    public boolean update(TicketClass entity) {

        String sqlQuery = "UPDATE ticketclases SET ticketclass_level=? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setInt(1, entity.getLevelComfort());
            preparedStatement.setInt(2, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(TicketClass entity) {
        String sqlQuery = "INSERT INTO ticketclases (ticketclass_level) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, entity.getLevelComfort());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(TicketClass entity) {
        String sqlQuery = "DELETE FROM ticketclases WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
