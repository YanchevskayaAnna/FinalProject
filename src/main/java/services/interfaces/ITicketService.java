package services.interfaces;

import model.Bonus;
import model.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> getAllTickets();
    Ticket getTicketId(Integer id);
    boolean updateTicket(Ticket ticket);
    boolean createTicket(Ticket ticket);
    boolean deleteTicket(Ticket ticket);
    boolean deleteTicketById(Integer id);
    Ticket payCruise(int idClient, int idCruise, int idTicketClass);
    int definePrice(int idCruise, List<Bonus> bonusList);
}
