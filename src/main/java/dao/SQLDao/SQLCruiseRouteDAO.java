package dao.SQLDao;

import dao.interfaces.ICruiseDAO;
import dao.interfaces.ICruiseRouteDAO;
import model.Cruise;
import model.CruiseRoute;
import model.Excursion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLCruiseRouteDAO extends SQLDao<CruiseRoute, Integer> implements ICruiseRouteDAO {

    public SQLCruiseRouteDAO(Connection connection) {
        super(CruiseRoute.class, Integer.class, connection);
    }

    @Override
    public List<CruiseRoute> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM cruises;");) {
            List<CruiseRoute> cruiseList = getAllCruisesFromResultSet(resultSet);
            return cruiseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<CruiseRoute> getAllCruisesFromResultSet(ResultSet resultSet) throws SQLException {

        List<CruiseRoute> cruiseList = new ArrayList<>();
        while (resultSet.next()) {
            CruiseRoute cruise = new CruiseRoute();
            cruise.setId(resultSet.getInt("id"));
            cruise.setIdCruise(resultSet.getInt("cruiseroute_idcruise"));
            cruise.setIdPort(resultSet.getInt("cruiseroute_idport"));
            cruise.setDateArrival(resultSet.getDate("cruiseroute_dateArrival").toLocalDate());
            cruiseList.add(cruise);
        }
        return cruiseList;
    }

    @Override
    public boolean update(CruiseRoute entity) {

        String sqlQuery = "UPDATE cruiseroutes SET cruiseroute_idCruise=?, cruiseroute_idPort=? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setInt(1, entity.getIdCruise());
            preparedStatement.setInt(2, entity.getIdPort());
            preparedStatement.setInt(3, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(CruiseRoute entity) {
        String sqlQuery = "INSERT INTO cruiseroutes (cruiseroute_idCruise, cruiseroute_idPort) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, entity.getIdCruise());
            preparedStatement.setInt(2, entity.getIdPort());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(CruiseRoute entity) {
        String sqlQuery = "DELETE FROM cruiseroutes WHERE id = ?";

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
    public List<CruiseRoute> getCruiseRoute(int cruiseID) {
        String sqlQuery = "SELECT * FROM cruise_routs WHERE cruiserout_idcruise = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, cruiseID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CruiseRoute> CruiseRouteList = getAllCruisesFromResultSet(resultSet);
            return CruiseRouteList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
