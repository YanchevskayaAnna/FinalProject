package dao.interfaces;

import model.Bonus;

import java.util.List;

public interface IBonusDAO extends IAbstractDAO<Bonus> {
    List<Bonus> defineBonuses(int idClient, int idCruise);
}
