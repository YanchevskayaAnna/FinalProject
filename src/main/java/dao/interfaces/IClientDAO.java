package dao.interfaces;

import model.*;

import java.util.List;
import java.util.Map;

public interface IClientDAO extends IAbstractDAO<Client> {

    Map<Excursion, Boolean> defineExcursions(int idClient, int idCruise);

 }
