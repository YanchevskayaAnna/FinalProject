package dao.interfaces;

import model.Bonus;
import model.Ticket;

import java.util.List;

public interface ITicketDAO extends IAbstractDAO<Ticket> {
   int definePrice(int idCruise, List<Bonus> bonusList);
}
