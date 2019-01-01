package services.impl;

import dao.interfaces.ITicketBonusesDAO;
import model.TicketBonuses;
import services.interfaces.ITicketBonusesService;

import java.util.List;

public class TicketBonusesService implements ITicketBonusesService {
    private ITicketBonusesDAO ticketDAO;

    public TicketBonusesService(ITicketBonusesDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public List<TicketBonuses> getAllTicketBonuses() {
        return ticketDAO.getAll();
    }

    @Override
    public TicketBonuses getTicketBonusesId(Integer id) {
        return ticketDAO.getById(id);
    }

    @Override
    public boolean updateTicketBonuses(TicketBonuses ticket) {
        return ticketDAO.update(ticket);
    }

    @Override
    public boolean createTicketBonuses(TicketBonuses ticket) {
        return ticketDAO.create(ticket);
    }

    @Override
    public boolean deleteTicketBonuses(TicketBonuses ticket) {
        return ticketDAO.delete(ticket);
    }

    @Override
    public boolean deleteTicketBonusesById(Integer id) {
        return ticketDAO.deleteById(id);
    }
}
