package dao.interfaces;

import model.*;

import java.util.List;
import java.util.Map;

public interface IClientDAO extends IAbstractDAO<Client> {

    List<Bonus> DefineBonuses(int idClient, int idCruise);
    Map<Excursion, Boolean> DefineExcursions(int idClient, int idCruise);
    List<Cruise> DefineCruises(int idClient);
    ExcursionTicket PayExcursion(int idClient, int idExcursion);
    Ticket PayCruise(int idClient, int idCruise, int idTicketClass);

}
