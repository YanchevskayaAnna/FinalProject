package dao.SQLDao;

import dao.interfaces.IExcursionTicketDAO;
import model.ExcursionTicket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLExcursionTicketDAO extends SQLDao<ExcursionTicket, Integer> implements IExcursionTicketDAO {

    public SQLExcursionTicketDAO(Connection connection) {
        super(ExcursionTicket.class, Integer.class, connection);
    }

    @Override
    public List<ExcursionTicket> getAll() {

        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM excursions_tickets;");) {
            List<ExcursionTicket> excursionList = getAllExcursionsFromResultSet(resultSet);
            return excursionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<ExcursionTicket> getAllExcursionsFromResultSet(ResultSet resultSet) throws SQLException {

        List<ExcursionTicket> excursionList = new ArrayList<>();
        while (resultSet.next()) {
            ExcursionTicket excursion = new ExcursionTicket();
            excursion.setId(resultSet.getInt("id"));
            excursion.setNumber(resultSet.getString("excursionticket_number"));
            excursion.setIdClient(resultSet.getInt("excursionticket_idclient"));
            excursion.setIdCruise(resultSet.getInt("excursionticket_idcruise"));
            excursionList.add(excursion);
        }
        return excursionList;
    }

    @Override
    public boolean update(ExcursionTicket entity) {

        String sqlQuery = "UPDATE excursions_tickets SET excursionticket_number=?, excursionticket_idclient=?,  excursionticket_idcruise =? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, entity.getNumber());
            preparedStatement.setInt(2, entity.getIdClient());
            preparedStatement.setInt(3, entity.getIdCruise());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(ExcursionTicket entity) {
        String sqlQuery = "INSERT INTO excursions_tickets (excursionticket_number, excursionticket_idclient, excursionticket_idcruise) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getNumber());
            preparedStatement.setInt(2, entity.getIdClient());
            preparedStatement.setInt(3, entity.getIdCruise());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ExcursionTicket entity) {
        String sqlQuery = "DELETE FROM excursions_tickets WHERE id = ?";

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
