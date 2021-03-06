package dao.SQLDao;

import dao.interfaces.ICruiseDAO;
import dao.interfaces.ICruiseRouteDAO;
import model.Cruise;
import model.CruiseRoute;
import model.Excursion;
import model.dto.CruiseRouteDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SQLCruiseRouteDAO extends SQLDao<CruiseRoute, Integer> implements ICruiseRouteDAO {

    public SQLCruiseRouteDAO(Connection connection) {
        super(CruiseRoute.class, Integer.class, connection);
    }

    @Override
    public List<CruiseRoute> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM cruise_routs;");) {
            List<CruiseRoute> cruiseList = getAllCruisesFromResultSet(resultSet);
            return cruiseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<CruiseRoute> getAllCruisesFromResultSet(ResultSet resultSet) throws SQLException {

        List<CruiseRoute> cruiseList = new ArrayList<>();
        while (resultSet.next()) {
            CruiseRoute cruise = new CruiseRoute();
            cruise.setId(resultSet.getInt("id"));
            cruise.setIdCruise(resultSet.getInt("cruiserout_idcruise"));
            cruise.setIdPort(resultSet.getInt("cruiserout_idport"));
            cruise.setDateArrival(resultSet.getDate("cruiserout_dateStart").toLocalDate());
            cruiseList.add(cruise);
        }
        return cruiseList;
    }

    @Override
    public boolean update(CruiseRoute entity) {

        String sqlQuery = "UPDATE cruise_routs SET cruiseroute_idCruise=?, cruiseroute_idPort=? WHERE id=?";

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
        String sqlQuery = "INSERT INTO cruise_routs (cruiseroute_idCruise, cruiseroute_idPort) VALUES (?,?)";

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
        String sqlQuery = "DELETE FROM cruise_routs WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public List<CruiseRouteDto> getAllCruisesDtoFromResultSet(ResultSet resultSet) throws SQLException {

        List<CruiseRouteDto> cruiseList = new ArrayList<>();
        while (resultSet.next()) {
            CruiseRouteDto cruise = new CruiseRouteDto();
            cruise.setId(resultSet.getInt("id"));
            cruise.setIdCruise(resultSet.getInt("cruiserout_idcruise"));
            cruise.setIdPort(resultSet.getInt("cruiserout_idport"));
            cruise.setDateArrival(resultSet.getDate("cruiserout_dateStart").toLocalDate());
            cruise.setPortName(resultSet.getString("port_name"));
            cruise.setCruiseName(resultSet.getString("cruise_name"));
            cruiseList.add(cruise);
        }
        return cruiseList;
    }


    @Override
    public List<CruiseRouteDto> getCruiseRoute(int cruiseID) {
        String sqlQuery = "SELECT * FROM cruise_routs Left Join ports ON cruise_routs.cruiserout_idport = ports.id Left Join cruises ON cruise_routs.cruiserout_idcruise = cruises.id WHERE cruiserout_idcruise = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, cruiseID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CruiseRouteDto> CruiseRouteList = getAllCruisesDtoFromResultSet(resultSet);
            return CruiseRouteList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
