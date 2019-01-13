package dao.interfaces;

import model.Bonus;
import model.Excursion;
import model.Ticket;
import model.User;

import java.util.List;
import java.util.Map;

public interface IUserDAO extends IAbstractDAO<User> {

    User getUser(String login, String password);
    Map<Excursion, Boolean> defineExcursions(int idUser, int idCruise);

}
