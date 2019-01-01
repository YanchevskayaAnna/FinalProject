package services.interfaces;

import model.Bonus;

import java.util.List;

public interface IBonusService {
    List<Bonus> getAllBonuses();
    List<Bonus> defineBonuses(int idClient, int idCruise);
    Bonus getBonusId(Integer id);
    boolean updateBonus(Bonus bonus);
    boolean createBonus(Bonus bonus);
    boolean deleteBonus(Bonus bonus);
    boolean deleteBonusById(Integer id);
}
