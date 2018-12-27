package services.impl;

import dao.interfaces.IExcursionTicketDAO;
import model.ExcursionTicket;
import services.interfaces.IExcursionTicketService;

public class ExcursionTicketService implements IExcursionTicketService {

    private IExcursionTicketDAO excursionTicketDAO;

    public ExcursionTicketService(IExcursionTicketDAO excursionTicketDAO) {
        this.excursionTicketDAO = excursionTicketDAO;
    }

    @Override
    public ExcursionTicket getExcursionTicketId(Integer id) {
        return excursionTicketDAO.getById(id);
    }

    @Override
    public boolean updateExcursionTicket(ExcursionTicket excursionTicket) {
        return excursionTicketDAO.update(excursionTicket);
    }

    @Override
    public boolean createExcursionTicket(ExcursionTicket excursionTicket) {
        return excursionTicketDAO.create(excursionTicket);
    }

    @Override
    public boolean deleteExcursionTicket(ExcursionTicket excursionTicket) {
        return excursionTicketDAO.delete(excursionTicket);
    }

    @Override
    public boolean deleteExcursionTicketById(Integer id) {
        return excursionTicketDAO.deleteById(id);
    }
}
