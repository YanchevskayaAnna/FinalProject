package dao.interfaces;

import model.*;

import java.util.List;
import java.util.Map;

public interface IClientDAO extends IAbstractDAO<Client> {

    List<Bonus> defineBonuses(int idClient, int idCruise);
    Map<Excursion, Boolean> defineExcursions(int idClient, int idCruise);
    List<Cruise> defineCruises(int idClient);
    ExcursionTicket payExcursion(int idClient, int idExcursion);
    Ticket payCruise(int idClient, int idCruise, int idTicketClass);

}
