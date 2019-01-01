package dao.SQLDao;

import dao.interfaces.ITicketDAO;
import model.Bonus;
import model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        return null;
    }

    public List<Ticket> getAllTicketsFromResultSet(ResultSet resultSet) throws SQLException {

        List<Ticket> ticketList = new ArrayList<>();
        while (resultSet.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(resultSet.getInt("id"));
            ticket.setNumber(resultSet.getInt("ticket_number"));
            ticket.setIdClient(resultSet.getInt("ticket_idclient"));
            ticket.setIdCruise(resultSet.getInt("ticket_idcruise"));
            ticket.setPrice(resultSet.getInt("ticket_price"));
            ticketList.add(ticket);
        }
        return ticketList;
    }

    @Override
    public boolean update(Ticket entity) {

        String sqlQuery = "UPDATE tickets SET ticket_number=?, ticket_price=?,ticket_idclient=?, ticket_idcruise=? WHERE id=?";

        try {
            if (getById(entity.getId()) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setInt(1, entity.getNumber());
            preparedStatement.setInt(2, entity.getPrice());
            preparedStatement.setInt(3, entity.getIdClient());
            preparedStatement.setInt(4, entity.getIdCruise());
            preparedStatement.setInt(5, entity.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Ticket entity) {
        String sqlQuery = "INSERT INTO tickets (ticket_number, ticket_price, ticket_idclient, ticket_idcruise) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, entity.getNumber());
            preparedStatement.setInt(2, entity.getPrice());
            preparedStatement.setInt(3, entity.getIdClient());
            preparedStatement.setInt(4, entity.getIdCruise());
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
        return 0;
    }
}
