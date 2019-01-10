package dao.SQLDao;

import dao.interfaces.ITicketBonusesDAO;
import dao.interfaces.ITicketDAO;
import model.Ticket;
import model.TicketBonuses;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLTicketBonusesDAO extends SQLDao<TicketBonuses, Integer> implements ITicketBonusesDAO {

    public SQLTicketBonusesDAO(Connection connection) {
        super(TicketBonuses.class, Integer.class, connection);
    }

    @Override
    public List<TicketBonuses> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ticketbonuses;");) {
            List<TicketBonuses> ticketList = getAllTicketsFromResultSet(resultSet);
            return ticketList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<TicketBonuses> getAllTicketsFromResultSet(ResultSet resultSet) throws SQLException {

        List<TicketBonuses> ticketList = new ArrayList<>();
        while (resultSet.next()) {
            TicketBonuses ticket = new TicketBonuses();
            ticket.setId(resultSet.getInt("id"));
            ticket.setIdBonus(resultSet.getInt("ticketbonuses_idBonus"));
            ticket.setIdTicket(resultSet.getInt("ticketbonuses_idTicket"));
            ticket.setPrice(resultSet.getInt("ticketbonuses_price"));
            ticketList.add(ticket);
        }
        return ticketList;
    }

    @Override
    public boolean update(TicketBonuses entity) {

        String sqlQuery = "UPDATE ticketbonuses SET ticketbonuses_idBonus=?, ticketbonuses_idTicket=? ,ticketbonuses_price=? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setInt(1, entity.getIdBonus());
            preparedStatement.setInt(2, entity.getIdTicket());
            preparedStatement.setInt(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(TicketBonuses entity) {
        String sqlQuery = "INSERT INTO ticketbonuses (ticketbonuses_idBonus, ticketbonuses_idTicket, ticketbonuses_price) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, entity.getIdBonus());
            preparedStatement.setInt(2, entity.getIdTicket());
            preparedStatement.setInt(3, entity.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(TicketBonuses entity) {
        String sqlQuery = "DELETE FROM ticketbonuses WHERE id = ?";

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
