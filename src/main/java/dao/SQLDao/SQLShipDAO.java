package dao.SQLDao;

import dao.interfaces.IShipDAO;
import model.Ship;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLShipDAO extends SQLDao<Ship, Integer> implements IShipDAO {

    public SQLShipDAO(Connection connection) {
        super(Ship.class, Integer.class, connection);
    }

    @Override
    public List<Ship> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ships;");) {
            List<Ship> shipList = getAllShipsFromResultSet(resultSet);
            return shipList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Ship> getAllShipsFromResultSet(ResultSet resultSet) throws SQLException {

        List<Ship> shipList = new ArrayList<>();
        while (resultSet.next()) {
            Ship ship = new Ship();
            ship.setId(resultSet.getInt("id"));
            ship.setName(resultSet.getString("ship_name"));
            ship.setNumber(resultSet.getString("ship_number"));
            ship.setPassengerCapacity(resultSet.getInt("ship_passengercapacity"));
            shipList.add(ship);
        }
        return shipList;
    }

    @Override
    public boolean update(Ship entity) {

        String sqlQuery = "UPDATE ships SET ship_name=?, ship_number=?, =? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getNumber());
            preparedStatement.setInt(3, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Ship entity) {
        String sqlQuery = "INSERT INTO ships (ship_name, ship_number, ship_passengercapacity) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getNumber());
            preparedStatement.setInt(3, entity.getPassengerCapacity());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Ship entity) {
        String sqlQuery = "DELETE FROM ships WHERE id = ?";

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
