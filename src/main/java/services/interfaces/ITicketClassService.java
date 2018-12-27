package services.interfaces;

import model.TicketClass;

public interface ITicketClassService {
    TicketClass getTicketId(Integer id);
    boolean updateTicketClass(TicketClass ticketClass);
    boolean createTicketClass(TicketClass ticketClass);
    boolean deleteTicketClass(TicketClass ticketClass);
    boolean deleteTicketClassById(Integer id);
}
