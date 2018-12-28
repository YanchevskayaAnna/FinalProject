package services.interfaces;

import model.ExcursionTicket;
import java.util.List;

public interface IExcursionTicketService {
    List<ExcursionTicket> getAllExcursionTickets();
    ExcursionTicket getExcursionTicketId(Integer id);
    boolean updateExcursionTicket(ExcursionTicket excursionTicket);
    boolean createExcursionTicket(ExcursionTicket excursionTicket);
    boolean deleteExcursionTicket(ExcursionTicket excursionTicket);
    boolean deleteExcursionTicketById(Integer id);
}
