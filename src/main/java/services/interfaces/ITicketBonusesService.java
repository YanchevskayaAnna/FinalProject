package services.interfaces;

import model.TicketBonuses;
import java.util.List;

public interface ITicketBonusesService {
    List<TicketBonuses> getAllTicketBonuses();
    TicketBonuses getTicketBonusesId(Integer id);
    boolean updateTicketBonuses(TicketBonuses ticketBonuses);
    boolean createTicketBonuses(TicketBonuses ticketBonuses);
    boolean deleteTicketBonuses(TicketBonuses ticketBonuses);
    boolean deleteTicketBonusesById(Integer id);
}
