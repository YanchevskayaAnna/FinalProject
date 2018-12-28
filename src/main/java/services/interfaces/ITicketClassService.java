package services.interfaces;

import model.TicketClass;

import java.util.List;

public interface ITicketClassService {
    List<TicketClass> getAllTicketClasses();
    TicketClass getTicketId(Integer id);
    boolean updateTicketClass(TicketClass ticketClass);
    boolean createTicketClass(TicketClass ticketClass);
    boolean deleteTicketClass(TicketClass ticketClass);
    boolean deleteTicketClassById(Integer id);
}
