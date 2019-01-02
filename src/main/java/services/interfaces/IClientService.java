package services.interfaces;

import model.*;

import java.util.List;
import java.util.Map;

public interface IClientService {
    List<Client> getAllClients();
    List<Bonus> defineBonuses(int idClient, int idCruise);
    Map<Excursion, Boolean> defineExcursions(int idClient, int idCruise);
    Client getClientId(Integer id);
    boolean updateClient(Client client);
    boolean createClient(Client client);
    boolean deleteClient(Client client);
    boolean deleteClientById(Integer id);
}
