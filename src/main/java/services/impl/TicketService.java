package services.impl;

import dao.interfaces.ITicketDAO;
import model.Ticket;
import services.interfaces.ITicketService;

import java.util.List;

public class TicketService implements ITicketService {
    private ITicketDAO ticketDAO;

    public TicketService(ITicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDAO.getAll();
    }

    @Override
    public Ticket getTicketId(Integer id) {
        return ticketDAO.getById(id);
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        return ticketDAO.update(ticket);
    }

    @Override
    public boolean createTicket(Ticket ticket) {
        return ticketDAO.create(ticket);
    }

    @Override
    public boolean deleteTicket(Ticket ticket) {
        return ticketDAO.delete(ticket);
    }

    @Override
    public boolean deleteTicketById(Integer id) {
        return ticketDAO.deleteById(id);
    }
}
