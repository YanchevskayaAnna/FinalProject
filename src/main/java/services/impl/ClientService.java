package services.impl;

import dao.interfaces.IClientDAO;
import model.*;
import services.interfaces.IClientService;

import java.util.List;
import java.util.Map;

public class ClientService implements IClientService {
    private IClientDAO clientDAO;

    public ClientService(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public List<Client> getAllClients() {
        return clientDAO.getAll();
    }

    @Override
    public List<Bonus> defineBonuses(int idClient, int idCruise) {
        return clientDAO.defineBonuses(idClient, idCruise);
    }

    @Override
    public Map<Excursion, Boolean> defineExcursions(int idClient, int idCruise) {
        return clientDAO.defineExcursions(idClient, idCruise);
    }

    @Override
    public List<Cruise> defineCruises(int idClient) {
        return clientDAO.defineCruises(idClient);
    }

    @Override
    public ExcursionTicket payExcursion(int idClient, int idExcursion) {
        return clientDAO.payExcursion(idClient, idExcursion);
    }

    @Override
    public Ticket payCruise(int idClient, int idCruise, int idTicketClass) {
        return clientDAO.payCruise(idClient, idCruise, idTicketClass);
    }

    @Override
    public Client getClientId(Integer id) {
        return clientDAO.getById(id);
    }

    @Override
    public boolean updateClient(Client client) {
        return clientDAO.update(client);
    }

    @Override
    public boolean createClient(Client client) {
        return clientDAO.create(client);
    }

    @Override
    public boolean deleteClient(Client client) {
        return clientDAO.delete(client);
    }

    @Override
    public boolean deleteClientById(Integer id) {
        return clientDAO.deleteById(id);
    }
}
