package services.impl;

import dao.interfaces.ITicketClassDAO;
import model.TicketClass;
import services.interfaces.ITicketClassService;

public class TicketClassService implements ITicketClassService {
    private ITicketClassDAO ticketClassDAO;

    public TicketClassService(ITicketClassDAO ticketClassDAO) {
        this.ticketClassDAO = ticketClassDAO;
    }

    @Override
    public TicketClass getTicketId(Integer id) {
        return ticketClassDAO.getById(id);
    }

    @Override
    public boolean updateTicketClass(TicketClass ticketClass) {
        return ticketClassDAO.update(ticketClass);
    }

    @Override
    public boolean createTicketClass(TicketClass ticketClass) {
        return ticketClassDAO.create(ticketClass);
    }

    @Override
    public boolean deleteTicketClass(TicketClass ticketClass) {
        return ticketClassDAO.delete(ticketClass);
    }

    @Override
    public boolean deleteTicketClassById(Integer id) {
        return ticketClassDAO.deleteById(id);
    }
}
