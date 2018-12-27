package services.interfaces;

import model.ExcursionTicket;

public interface IExcursionTicketService {
    ExcursionTicket getExcursionTicketId(Integer id);
    boolean updateExcursionTicket(ExcursionTicket excursionTicket);
    boolean createExcursionTicket(ExcursionTicket excursionTicket);
    boolean deleteExcursionTicket(ExcursionTicket excursionTicket);
    boolean deleteExcursionTicketById(Integer id);
}
