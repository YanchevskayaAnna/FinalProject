package dao.SQLDao;

import dao.interfaces.ICruiseDAO;
import model.Cruise;
import model.CruiseRoute;
import model.Excursion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLCruiseDAO extends SQLDao<Cruise, Integer> implements ICruiseDAO {

    public SQLCruiseDAO(Connection connection) {
        super(Cruise.class, Integer.class, connection);
    }

    @Override
    public List<Cruise> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM cruises;");) {
            List<Cruise> cruiseList = getAllCruisesFromResultSet(resultSet);
            return cruiseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Cruise> getAllCruisesFromResultSet(ResultSet resultSet) throws SQLException {

        List<Cruise> cruiseList = new ArrayList<>();
        while (resultSet.next()) {
            Cruise cruise = new Cruise();
            cruise.setId(resultSet.getInt("id"));
            cruise.setName(resultSet.getString("cruise_name"));
            cruise.setNumber(resultSet.getString("cruise_number"));
            cruise.setPrice(resultSet.getInt("cruise_price"));
            cruise.setCountOfDays(resultSet.getInt("cruise_countdays"));
            cruise.setIdShip(resultSet.getInt("cruise_idShip"));
            cruise.setDateStart(resultSet.getDate("cruise_dateStart").toLocalDate());
            cruise.setDateFinish(resultSet.getDate("cruise_dateFinish").toLocalDate());
            cruiseList.add(cruise);
        }
        return cruiseList;
    }

    @Override
    public boolean update(Cruise entity) {

        String sqlQuery = "UPDATE cruises SET cruise_name=?, cruise_number=? WHERE id=?";

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
    public boolean create(Cruise entity) {
        String sqlQuery = "INSERT INTO cruises (cruise_name, cruise_number) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Cruise entity) {
        String sqlQuery = "DELETE FROM cruises WHERE id = ?";

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
    public int calculateCountPassengers(int cruiseID) {

        String sqlQuery = "SELECT COUNT(id) id FROM tickets WHERE ticket_idcruise = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, cruiseID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int countNumberEmptySeats(int cruiseID) {
        String sqlQuery = "SELECT (MAX(ships.ship_passengercapacity) - COUNT(tickets.id)) countEmptySeats FROM tickets LEFT JOIN cruises LEFT JOIN ships ON cruises.cruise_idShip = ships.id ON tickets.ticket_idcruise = cruises.id WHERE ticket_idcruise = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, cruiseID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getInt("countEmptySeats");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Cruise> identifyCurrentCruises(LocalDate date) {
        String sqlQuery = "SELECT * FROM cruises WHERE cruise_dateStart < ? AND cruise_dateFinish > ?"; // to do WHERE ? BETWEEN cruise_dateStart AND cruise_dateFinish"
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setDate(1, java.sql.Date.valueOf(date));
            preparedStatement.setDate(2, java.sql.Date.valueOf(date));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruiseList = getAllCruisesFromResultSet(resultSet);
            return cruiseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cruise> determinePlannedCruises(LocalDate date) {
        String sqlQuery = "SELECT * FROM cruises WHERE cruise_dateStart > ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setDate(1, java.sql.Date.valueOf(date));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruiseList = getAllCruisesFromResultSet(resultSet);
            return cruiseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Cruise> defineCruises(int idClient) {
        String sqlQuery = "SELECT * FROM cruises INNER JOIN tickets ON cruises.id = tickets.ticket_idcruise AND tickets.ticket_idclient = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, idClient);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cruise> cruiseList = getAllCruisesFromResultSet(resultSet);
            return cruiseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
