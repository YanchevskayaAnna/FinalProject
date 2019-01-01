package dao.SQLDao;

import dao.interfaces.IClientDAO;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
            client.setMail(resultSet.getString("client_mail"));
            client.setPhone(resultSet.getString("client_phone"));
            clientList.add(client);
        }
        return clientList;
    }

    @Override
    public boolean update(Client entity) {

        String sqlQuery = "UPDATE clients SET client_name=?, client_mail=?, client_phone=?  WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getMail());
            preparedStatement.setString(3, entity.getPhone());
            preparedStatement.setInt(4, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Client entity) {
        String sqlQuery = "INSERT INTO clients (client_name, client_mail, client_phone) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getMail());
            preparedStatement.setString(3, entity.getPhone());
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
    public Map<Excursion, Boolean> defineExcursions(int idClient, int idCruise) {
        String sqlQuery = "SELECT excursions.*, excursions_tickets.id idTicket FROM excursions INNER JOIN cruise_routs ON excursions.excursion_id_port = cruise_routs.cruiserout_idport AND cruise_routs.cruiserout_idcruise = ?" +
                "LEFT JOIN excursions_tickets ON excursions.id = excursions_tickets.excursionticket_idExcursion AND excursions_tickets.excursionticket_idclient = ?";

        Map<Excursion, Boolean> excursionMap = new HashMap<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, idCruise);
            preparedStatement.setInt(2, idClient);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Excursion excursion = new Excursion();
                excursion.setId(resultSet.getInt("id"));
                excursion.setName(resultSet.getString("excursion_name"));
                excursion.setPrice(resultSet.getInt("excursion_price"));
                excursion.setIdPort(resultSet.getInt("excursion_id_port"));
                Integer excursionPaid = resultSet.getInt("idTicket");
                excursionMap.put(excursion, excursionPaid != null);
            }
            return excursionMap;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ExcursionTicket payExcursion(int idClient, int idExcursion) {
        return null;
    }

    @Override
    public Ticket payCruise(int idClient, int idCruise, int idTicketClass) {
        return null;
    }
}
