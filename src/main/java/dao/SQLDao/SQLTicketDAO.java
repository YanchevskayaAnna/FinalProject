package dao.SQLDao;

import dao.interfaces.ITicketDAO;
import model.Bonus;
import model.Excursion;
import model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SQLTicketDAO extends SQLDao<Ticket, Integer> implements ITicketDAO {

    public SQLTicketDAO(Connection connection) {
        super(Ticket.class, Integer.class, connection);
    }

    @Override
    public List<Ticket> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM tickets;");) {
            List<Ticket> ticketList = getAllTicketsFromResultSet(resultSet);
            return ticketList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<Ticket> getAllTicketsFromResultSet(ResultSet resultSet) throws SQLException {

        List<Ticket> ticketList = new ArrayList<>();
        while (resultSet.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(resultSet.getInt("id"));
            ticket.setIdClient(resultSet.getInt("ticket_idclient"));
            ticket.setIdCruise(resultSet.getInt("ticket_idcruise"));
            ticket.setPrice(resultSet.getInt("ticket_price"));
            ticketList.add(ticket);
        }
        return ticketList;
    }

    @Override
    public boolean update(Ticket entity) {

        String sqlQuery = "UPDATE tickets SET ticket_price=?,ticket_idclient=?, ticket_idcruise=? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setInt(1, entity.getPrice());
            preparedStatement.setInt(2, entity.getIdClient());
            preparedStatement.setInt(3, entity.getIdCruise());
            preparedStatement.setInt(4, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Ticket entity) {
        String sqlQuery = "INSERT INTO tickets (ticket_price, ticket_idclient, ticket_idcruise) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, entity.getPrice());
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
    public boolean delete(Ticket entity) {
        String sqlQuery = "DELETE FROM tickets WHERE id = ?";

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
    public int definePrice(int idCruise, List<Bonus> bonusList) {
        String bonusID = bonusList.stream().map(bonus ->bonus.getId().toString()).collect(Collectors.joining(", "));
        String sqlQuery = "SELECT (MAX(cruises.cruise_price) + SUM(bonuses.bonus_price)) price FROM cruises LEFT JOIN  bonuses ON bonuses.id IN (" +  bonusID + ") WHERE cruises.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, idCruise);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            return resultSet.next() ? resultSet.getInt("price") : 0 ;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
