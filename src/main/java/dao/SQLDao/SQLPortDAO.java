package dao.SQLDao;

import dao.interfaces.IPortDAO;
import model.Excursion;
import model.Port;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLPortDAO extends SQLDao<Port, Integer> implements IPortDAO {

    public SQLPortDAO(Connection connection) {
        super(Port.class, Integer.class, connection);
    }

    @Override
    public List<Port> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM cruises;");) {
            List<Port> portList = getAllPortsFromResultSet(resultSet);
            return portList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<Port> getAllPortsFromResultSet(ResultSet resultSet) throws SQLException {

        List<Port> portList = new ArrayList<>();
        while (resultSet.next()) {
            Port port = new Port();
            port.setId(resultSet.getInt("id"));
            port.setName(resultSet.getString("cruise_name"));
            portList.add(port);
        }
        return portList;
    }

    @Override
    public boolean update(Port entity) {

        String sqlQuery = "UPDATE ports SET port_name=? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Port entity) {
        String sqlQuery = "INSERT INTO ports (port_name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Port entity) {
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

    public List<Excursion> getAllExcursionsFromResultSet(ResultSet resultSet) throws SQLException {

        List<Excursion> excursionList = new ArrayList<>();
        while (resultSet.next()) {
            Excursion excursion = new Excursion();
            excursion.setId(resultSet.getInt("id"));
            excursion.setName(resultSet.getString("excursion_name"));
            excursion.setPrice(resultSet.getInt("excursion_price"));
            excursion.setIdPort(resultSet.getInt("excursion_idPort"));
            excursionList.add(excursion);
        }
        return excursionList;
    }


    @Override
    public List<Excursion> findExcursions(int portID) {
        String sqlQuery = "SELECT * FROM excursions WHERE id_port = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, portID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Excursion> excursionList = getAllExcursionsFromResultSet(resultSet);
            return excursionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

}
