package dao.SQLDao;

import dao.interfaces.IExcursionDAO;
import model.Excursion;

import java.sql.*;
import java.util.ArrayList;
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

        return null;
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

        return null;
    }
}
