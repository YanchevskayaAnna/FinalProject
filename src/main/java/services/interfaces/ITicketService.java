package services.interfaces;

import model.Ticket;

public interface ITicketService {
    Ticket getTicketId(Integer id);
    boolean updateTicket(Ticket ticket);
    boolean createTicket(Ticket ticket);
    boolean deleteTicket(Ticket ticket);
    boolean deleteTicketById(Integer id);
}
