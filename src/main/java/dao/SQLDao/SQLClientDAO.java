package dao.SQLDao;

import dao.interfaces.IClientDAO;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLClientDAO extends SQLDao<Client, Integer> implements IClientDAO {

    public SQLClientDAO(Connection connection) {
        super(Client.class, Integer.class, connection);
    }

    @Override
    public List<Client> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM clients;");) {
            List<Client> clientList = getAllClientsFromResultSet(resultSet);
            return clientList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Client> getAllClientsFromResultSet(ResultSet resultSet) throws SQLException {

        List<Client> clientList = new ArrayList<>();
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("client_name"));
            client.setIdentificationNumber(resultSet.getString("client_inn"));
            clientList.add(client);
        }
        return clientList;
    }

    @Override
    public boolean update(Client entity) {

        String sqlQuery = "UPDATE clients SET client_name=?, client_inn=? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getIdentificationNumber());
            preparedStatement.setInt(3, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Client entity) {
        String sqlQuery = "INSERT INTO clients (client_name, client_inn) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getIdentificationNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Client entity) {
        String sqlQuery = "DELETE FROM clients WHERE id = ?";

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
    public List<Bonus> DefineBonuses(int idClient, int idCruise) {
        return null;
    }

    @Override
    public Map<Excursion, Boolean> DefineExcursions(int idClient, int idCruise) {
        return null;
    }

    @Override
    public List<Cruise> DefineCruises(int idClient) {
        return null;
    }

    @Override
    public ExcursionTicket PayExcursion(int idClient, int idExcursion) {
        return null;
    }

    @Override
    public Ticket PayCruise(int idClient, int idCruise, int idTicketClass) {
        return null;
    }
}
