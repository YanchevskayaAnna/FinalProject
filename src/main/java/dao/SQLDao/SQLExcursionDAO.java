package dao.SQLDao;

import dao.interfaces.IExcursionDAO;
import model.Cruise;
import model.Excursion;
import model.Port;
import model.dto.ExcursionCruiseDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLExcursionDAO extends SQLDao<Excursion, Integer> implements IExcursionDAO {

    public SQLExcursionDAO(Connection connection) {
        super(Excursion.class, Integer.class, connection);
    }

    @Override
    public List<Excursion> getAll() {

        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM excursions;");) {
            List<Excursion> excursionList = getAllExcursionsFromResultSet(resultSet);
            return excursionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<Excursion> getAllExcursionsFromResultSet(ResultSet resultSet) throws SQLException {

        List<Excursion> excursionList = new ArrayList<>();
        while (resultSet.next()) {
            Excursion excursion = new Excursion();
            excursion.setId(resultSet.getInt("id"));
            excursion.setName(resultSet.getString("excursion_name"));
            excursion.setPrice(resultSet.getInt("excursion_price"));
            excursion.setIdPort(resultSet.getInt("excursion_id_port"));
            excursionList.add(excursion);
        }
        return excursionList;
    }

    @Override
    public boolean update(Excursion entity) {

        String sqlQuery = "UPDATE excursions SET excursion_name=?, excursion_price=?,  excursion_idPort=? WHERE id=?";

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
            preparedStatement.setInt(3, entity.getIdPort());
            preparedStatement.setInt(4, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Excursion entity) {
        String sqlQuery = "INSERT INTO excursions (excursion_name, excursion_price, excursion_idPort) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getPrice());
            preparedStatement.setInt(3, entity.getIdPort());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Excursion entity) {
        String sqlQuery = "DELETE FROM excursions WHERE id = ?";

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
    public List<Excursion> getPortExcursions(int idPort) {
        String sqlQuery = "SELECT * FROM excursions WHERE excursion_id_port = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, idPort);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Excursion> excursionList = getAllExcursionsFromResultSet(resultSet);
            return excursionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public List<Excursion> findCruiseExcursions(int cruiseID) {
        String sqlQuery = "SELECT * FROM excursions INNER JOIN cruise_routs ON excursions.excursion_id_port = cruise_routs.cruiserout_idport AND cruise_routs.cruiserout_idcruise = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, cruiseID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Excursion> excursionList = getAllExcursionsFromResultSet(resultSet);
            return excursionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<ExcursionCruiseDto> getAllExcursionsDtoFromResultSet(ResultSet resultSet) throws SQLException {

        List<ExcursionCruiseDto> excursionList = new ArrayList<>();
        while (resultSet.next()) {
            ExcursionCruiseDto excursion = new ExcursionCruiseDto();
            excursion.setId(resultSet.getInt("id"));
            excursion.setName(resultSet.getString("excursion_name"));
            excursion.setPrice(resultSet.getInt("excursion_price"));
            excursion.setPortID(resultSet.getInt("port_id"));
            excursion.setPortName(resultSet.getString("port_name"));
            excursion.setCruiseID(resultSet.getInt("cruise_id"));
            excursion.setCruiseName(resultSet.getString("cruise_name"));
            //excursion.setIdPort(resultSet.getInt("excursion_id_port"));
            excursionList.add(excursion);
        }
        return excursionList;
    }

    @Override
    public List<ExcursionCruiseDto> defineExcursions(int clientID) {
        String sqlQuery =
                "Select excursions.id, excursions.excursion_name, excursions.excursion_price," +
                 " ports.id port_id, ports.port_name, " +
                        "cruises.id cruise_id, cruises.cruise_name  from excursions_tickets \n" +
                "LEFT JOIN excursions ON excursions_tickets.excursionticket_idExcursion = excursions.id \n" +
                "LEFT JOIN cruises ON excursions_tickets. excursionticket_idcruise\n" +
                " = cruises.id\n" +
                "LEFT JOIN ports ON excursions.excursion_id_port  = ports.id\n" +
                "WHERE excursions_tickets.excursionticket_idclient = ?;\n";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, clientID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ExcursionCruiseDto> excursionList = getAllExcursionsDtoFromResultSet(resultSet);
            return excursionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
